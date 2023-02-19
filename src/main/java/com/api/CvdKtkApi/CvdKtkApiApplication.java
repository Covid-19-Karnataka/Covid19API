package com.api.CvdKtkApi;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.api.CvdKtkApi.Constants.Constants;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;

@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
@EnableScheduling
public class CvdKtkApiApplication {

	public static void main(String[] args) throws IOException {

		ClassPathResource resource = new ClassPathResource("serviceKey.json");
		InputStream inputStream = resource.getInputStream();

		try {
			FirebaseOptions options;

			options = FirebaseOptions.builder().setCredentials(GoogleCredentials.fromStream(inputStream))
					.setDatabaseUrl("https://corona-karnataka-2020.firebaseio.com").build();
			FirebaseApp.initializeApp(options);

			SpringApplication.run(CvdKtkApiApplication.class, args);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
