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
		String TWITTER_OAUTH2_CLIENT_ID = "UFJDMTBRb2NsaHhPejU2dVhwcDA6MTpjaQ";
		String TWITTER_OAUTH2_CLIENT_SECRET = "xbgOT8xJq2R0VSGxS21zfXt3xnZO4-Qvqg2snCIB7WxwKrSNVG";
		String TWITTER_OAUTH2_ACCESS_TOKEN = "1328990731-eG5NGSIWjZC8xSR0AxKTkwgjdj41SO8zu0FFNlA";
		String TWITTER_OAUTH2_BEARER_TOKEN = "AAAAAAAAAAAAAAAAAAAAAIekkwEAAAAAnUXIQZ97z7IM3sP8xoXai4%2BPX%2F0%3DHI1IPYuXKjdDQGVVucH0vOQYoKXrcg0itGfc6FXXPs6ZNOiwEM";
	}
	
	public interface DateFormat
	{
		String dd_MM_yyyy_HH_mm = "dd-MM-yyyy HH:mm";
		String dd_MM_yyyy = "dd-MM-yyyy";
		String yyyy_MM_dd = "YYYY-MM-dd";
	}
	
	
	public interface Twillo
	{
		String ACCOUNT_SID = "AC417fe5ca4371e6031193d46e869445dc";
		String AUTH_TOKEN = "c1dca5da4f54064e4e468ed7b7cc398c";
		String SERVICE_KEY = "VA4029c2521f8e229cc68d64de74133c0e";
	}

}
