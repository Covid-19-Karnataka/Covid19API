package com.api.CvdKtkApi.Model;

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
public class TwitterSrcDataFirebaseModel {

	String date;
	String driveLink;
	String id;
	String text;

}
