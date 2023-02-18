package com.api.CvdKtkApi.Utils;

import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;

@Component
public class GeneralUtils {
	
	public String currentTimeStamp(String format) {
		Date date = new Date();
		String timestamp = new SimpleDateFormat(format).format(new Timestamp(date.getTime()));
		return timestamp;

	}
	
	public List<String> twitterLongUrl(String text)
	{		
        Pattern pattern = Pattern.compile("(?i)\\b((?:https?://|www\\d?\\.|[a-z0-9.-]+\\.[a-z]{2,4}/)(?:[^\n\\s()<>]+|\\((?:[^\n\\s()<>]+|(?:\\([^\\n\\s()<>]+\\)))*\\))+(?:\\((?:[^\n\\s()<>]+|(?:\\([^\\n\\s()<>]+\\)))*\\)|[^\n\\s`!()\\[\\]{};:'\".,<>?«»“”‘’]))");
        List<String> urlList= new ArrayList<String>();
        
        Matcher matcher = pattern.matcher(text);
        String url = null;
        while (matcher.find()) {
        	urlList.add(matcher.group());
        }
		return urlList;
		
	}
	
	public String LongUrl(String tweetUrl) throws Exception
	{
//		String addr = "http://t.co/y4o14bI";
		URL url = new URL(tweetUrl);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setInstanceFollowRedirects(false);
        conn.connect();
        String expandedUrl = conn.getHeaderField("Location");
		return expandedUrl;
	}

}
