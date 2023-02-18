package com.api.CvdKtkApi.Model;

import java.util.List;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EntityScan
public class TwitterResponseModel {
	
	List<Tweets> data;
	MetaData meta;
	
	@Getter
	@Setter
	@AllArgsConstructor
	@NoArgsConstructor
	@EntityScan
	public class Tweets
	{
		List<String> edit_history_tweet_ids;
		String id;
		String text;
	}
	
	@Getter
	@Setter
	@AllArgsConstructor
	@NoArgsConstructor
	@EntityScan
	public class MetaData
	{
		int result_count;
		String newest_id;
		String oldest_id;
	}

}
