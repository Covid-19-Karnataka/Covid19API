package com.api.CvdKtkApi.ScheduledTriggers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.api.CvdKtkApi.Constants.Constants;
import com.api.CvdKtkApi.Utils.GeneralUtils;

@Component
public class ScheduledJobs {

	@Autowired
	TwitterSchedule twitterSchedule;

	@Autowired
	GeneralUtils gUtils;
	
	@Scheduled(cron = "01 01 12 * * ?")
	@Scheduled(cron = "01 59 23 * * ?")
	public void scrapTweetViaCron()
	{
		String dateTime = gUtils.currentTimeStamp(Constants.DateFormat.dd_MM_yyyy_HH_mm);
		System.out.println("Cron Expression Triggered at : "+dateTime);
		String day = gUtils.currentTimeStamp(Constants.DateFormat.yyyy_MM_dd);
		twitterSchedule.scrapTweet(day);
	}
	
	
}
