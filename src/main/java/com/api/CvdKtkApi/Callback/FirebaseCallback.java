package com.api.CvdKtkApi.Callback;

import java.util.List;

import org.springframework.stereotype.Component;

import com.api.CvdKtkApi.Model.DistrictDataFirebaseModel;

@Component
public class FirebaseCallback {
	
	
	public List<DistrictDataFirebaseModel> returnDistrictData(List<DistrictDataFirebaseModel> distList)
	{
		return distList;
	}

}
