package com.api.CvdKtkApi.PostFromWebsite;

import org.springframework.stereotype.Component;

import com.api.CvdKtkApi.Constants.Constants;
import com.twilio.Twilio;
import com.twilio.rest.verify.v2.Service;
import com.twilio.rest.verify.v2.service.Verification;
import com.twilio.rest.verify.v2.service.VerificationCheck;

@Component
public class FeedbackServiceImpl {
	
	
	public String setFeedBack(String phno)
	{
		Twilio.init(Constants.Twillo.ACCOUNT_SID, Constants.Twillo.AUTH_TOKEN);
		Service service = Service.creator("Covid19-Karnataka Feedback").create();

		Verification verification = Verification.creator(
                Constants.Twillo.SERVICE_KEY,
                "+91"+phno,
                "sms")
            .create();

		return verification.getStatus();
		
	}
	
	
	
	public String verifyOTP(String phone, String otp)
	{
		Twilio.init(Constants.Twillo.ACCOUNT_SID, Constants.Twillo.AUTH_TOKEN);

		 VerificationCheck verificationCheck = VerificationCheck.creator(
				 Constants.Twillo.SERVICE_KEY)
	            .setTo("+91"+phone)
	            .setCode(otp)
	            .create();
		return verificationCheck.getStatus();
		
	}

}
