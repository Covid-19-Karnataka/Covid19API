package com.api.CvdKtkApi.Constants;

import org.springframework.stereotype.Component;

@Component
public class Constants {
	
	public interface ConnectionAPI
	{
		String DATABASE_URL = "https://corona-karnataka-2020.firebaseio.com";
		String SERVICE_KEY = "serviceKey.json";
	}
	
	
	public interface Schema
	{
	
		String COMMENTS = "comments";
		String PAGEHITS = "pagehits";
		String SHOWFEEDBACK = "showfeedback";
		String DISTRICT_DATA_TIME_SERIES = "stats";
		String TWITTER_DATA = "twitterSrcData";
		String USERS = "users";	
	}
	
	public interface TwitterAPI
	{
		String TWITTER_OAUTH2_CLIENT_ID = "xxx";
		String TWITTER_OAUTH2_CLIENT_SECRET = "xx-xx";
		String TWITTER_OAUTH2_ACCESS_TOKEN = "xx-xx";
		String TWITTER_OAUTH2_BEARER_TOKEN = "xxx";
	}
	
	public interface DateFormat
	{
		String dd_MM_yyyy_HH_mm = "dd-MM-yyyy HH:mm";
		String dd_MM_yyyy = "dd-MM-yyyy";
		String yyyy_MM_dd = "YYYY-MM-dd";
	}
	
	
	public interface Twillo
	{
		String ACCOUNT_SID = "xxx";
		String AUTH_TOKEN = "xxx";
		String SERVICE_KEY = "xxx";
	}

}
