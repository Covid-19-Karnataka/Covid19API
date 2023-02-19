package com.api.CvdKtkApi;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Objects;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.api.CvdKtkApi.Constants.Constants;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;


@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableScheduling
public class CvdKtkApiApplication {

	public static void main(String[] args) throws FileNotFoundException {
		
		
		ClassLoader classLoader = CvdKtkApiApplication.class.getClassLoader();
		

//		File file = new File(Objects.requireNonNull(classLoader.getResource(Constants.ConnectionAPI.SERVICE_KEY.toString())).getFile());
//		FileInputStream file = new FileInputStream(CvdKtkApiApplication.class.getClassLoader().getResource("ssl_certs/mysslstore.jks").getFile());
		File file = new File(classLoader.getResource(Constants.ConnectionAPI.SERVICE_KEY).getFile());
		try {
			FirebaseOptions options;
			FileInputStream serviceAccount =
					  new FileInputStream(file);
		
			options = FirebaseOptions.builder()
				    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
				    .setDatabaseUrl(Constants.ConnectionAPI.DATABASE_URL)
				    .build();
			FirebaseApp.initializeApp(options);
			
			SpringApplication.run(CvdKtkApiApplication.class, args);
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
