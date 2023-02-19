package com.api.CvdKtkApi.RestController;

import java.io.IOException;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

// import com.api.CvdKtkApi.Callback.FirebaseCallback;
import com.api.CvdKtkApi.Constants.Constants;
// import com.api.CvdKtkApi.ScheduledTriggers.DriveSchedule;
// import com.api.CvdKtkApi.ScheduledTriggers.PythonScriptExecuter;
import com.api.CvdKtkApi.ScheduledTriggers.TwitterSchedule;
import com.api.CvdKtkApi.Utils.HttpRequestUtils;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

@RestController
public class FirebaseAPI {
	
	// @Autowired
	// FirebaseCallback callback;
	
	// @Autowired
	// HttpRequestUtils httpRequestUtils;
	
	// @Autowired
	// DriveSchedule driveSchedule;
	
	// @Autowired
	// PythonScriptExecuter scriptExecuter;
	
	@Autowired
	TwitterSchedule twitterSchedule;
	
	// DatabaseReference ref = FirebaseDatabase.getInstance().getReference("/stats/distDataTimeSeries");
	
	 @RequestMapping(method = RequestMethod.GET, value = "/")
	 public String helloWorld() throws IOException
	 {
	 	return "Hello world!";
	 }

	// @RequestMapping(method = RequestMethod.GET, value = "/delete")
	// public void testReturn()
	// {
	// 	System.out.println("deleting");
	// 	ref.addListenerForSingleValueEvent(new ValueEventListener() {
			
	// 		public void onDataChange(DataSnapshot snapshot) {
	// 			// TODO Auto-generated method stub
	// 			for (DataSnapshot appleSnapshot: snapshot.getChildren()) {
	// 	            appleSnapshot.getRef().removeValueAsync();
	// 	        }
	// 		}
			
	// 		public void onCancelled(DatabaseError error) {
	// 			// TODO Auto-generated method stub
				
	// 		}
	// 	});
	// }
	
//	@RequestMapping(method = RequestMethod.GET, value = "/latest")
//	public String latestData() throws IOException
//	{
//		
//		try {
//			JSONObject jsonObj;
//			StringBuffer response = httpRequestUtils.getRequest(Constants.Schema.DISTRICT_DATA_TIME_SERIES);
//			jsonObj = new JSONObject(response.toString());
//			int length = jsonObj.length();
//			return "Hello";
//		} catch (JSONException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return null;
//
//	}
	
	// @RequestMapping(method = RequestMethod.GET, value = "/trigger")
	// public void testSchedule()
	// {
	// 	scriptExecuter.PythonExec("");
	// }
	
	
	@RequestMapping(method = RequestMethod.GET, value = "getTweet/{date}")
	public void getTwitterDataManually(@PathVariable(value="date") String date) throws IOException
	{
		
		System.out.println("Inside getTwitterDataManually of FirebaseAPI");
		System.out.println(date);
		twitterSchedule.scrapTweet(date);
	}
}
