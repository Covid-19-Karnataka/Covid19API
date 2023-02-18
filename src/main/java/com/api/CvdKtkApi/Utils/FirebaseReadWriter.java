package com.api.CvdKtkApi.Utils;

import org.springframework.stereotype.Component;

import com.api.CvdKtkApi.Model.TwitterSrcDataFirebaseModel;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

@Component
public class FirebaseReadWriter {
	
	public void FirebaseTwitterWriter(String schema, String key, TwitterSrcDataFirebaseModel srcData)
	{
		System.out.println("Inside FirebaseTwitterWriter of FirebaseReadWriter");
		DatabaseReference ref = FirebaseDatabase.getInstance().getReference(schema);
		FirebaseAuth.getInstance();
		ref.child(key).setValueAsync(srcData);

	}

}
