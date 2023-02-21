package com.api.CvdKtkApi.ScheduledTriggers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.api.CvdKtkApi.Constants.Constants;
import com.api.CvdKtkApi.Model.TwitterResponseModel;
import com.api.CvdKtkApi.Model.TwitterResponseModel.Tweets;
import com.api.CvdKtkApi.Model.TwitterSrcDataFirebaseModel;
import com.api.CvdKtkApi.Utils.FirebaseReadWriter;
import com.api.CvdKtkApi.Utils.GeneralUtils;
import com.google.gson.Gson;

@Component
public class TwitterSchedule {

	@Autowired
	GeneralUtils gUtils;
	
	@Autowired
	FirebaseReadWriter readWriter;
	
	@SuppressWarnings("unused")
	public void scrapTweet(String day) {
		System.out.println("Inside scrapTweet of TwitterSchedule");
		try {
			TwitterResponseModel response = getTweet(day);
			List<TwitterSrcDataFirebaseModel> respList = processResponse(response, day);

			if (respList!=null) {
				for(TwitterSrcDataFirebaseModel srcData : respList)
				{
					readWriter.FirebaseTwitterWriter(Constants.Schema.TWITTER_DATA, srcData.getDate(), srcData);
				}
			}
			else
			{
				String dateTime = gUtils.currentTimeStamp(Constants.DateFormat.dd_MM_yyyy_HH_mm);

				System.out.println("No Tweets for timestamp: "+dateTime);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unused")
	private List<TwitterSrcDataFirebaseModel> processResponse(TwitterResponseModel response, String day) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Inside processResponse of TwitterSchedule");

		List<Tweets> list = response.getData();
		List<TwitterSrcDataFirebaseModel> firebaseModelsList = new ArrayList<TwitterSrcDataFirebaseModel>();

		if (list!=null)
		{
			for (Tweets tweet : list) {
				String tweetText = tweet.getText();
				String id = tweet.getId().toString();
				if (tweetText.contains("Today's Media Bulletin")) {
					List<String> tweetURlList = gUtils.twitterLongUrl(tweetText);
					String driveLink = gUtils.LongUrl(tweetURlList.get(0));

					TwitterSrcDataFirebaseModel model = new TwitterSrcDataFirebaseModel();
					model.setDate(day);
					model.setDriveLink(driveLink);
					model.setId(id);
					model.setText(tweetText);

					firebaseModelsList.add(model);
				}
			}

			return firebaseModelsList;
		}
		else
		{
			return null;
		}
		
	
	}

	public TwitterResponseModel getTweet(String day) throws IOException {
		System.out.println("Inside getTweet of TwitterSchedule");
		URL url = new URL("https://api.twitter.com/2/users/826734320018661378/tweets?max_results=100&start_time=" + day
				+ "T00:00:01.530Z&end_time=" + day + "T23:59:59.530Z");
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestProperty("Authorization", "Bearer " + Constants.TwitterAPI.TWITTER_OAUTH2_BEARER_TOKEN);

		conn.setRequestProperty("Content-Type", "application/json");
		conn.setRequestMethod("GET");

		BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		String output;

		StringBuffer response = new StringBuffer();
		while ((output = in.readLine()) != null) {
			response.append(output);
		}

		in.close();

		TwitterResponseModel resp = new TwitterResponseModel();
		resp = new Gson().fromJson(response.toString(), TwitterResponseModel.class);
		return resp;
	}

}
