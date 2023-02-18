package com.api.CvdKtkApi.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DistrictDataFirebaseModel {
	
	String date;
	String district;
	Long today_positive;
	Long today_discharge;
	Long today_deaths;
	Long today_other;
	Long total_positive;
	Long total_discharge;
	Long total_deaths;
	Long total_other;
	

}
