package com.api.CvdKtkApi.Utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

import org.springframework.stereotype.Component;

import com.api.CvdKtkApi.Constants.Constants;

@Component
public class HttpRequestUtils {
	
	public StringBuffer getRequest(String schema) throws IOException
	{
		URL obj = new URL(Constants.ConnectionAPI.DATABASE_URL+"/"+schema+".json");
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		con.setRequestMethod("GET");
		int responseCode = con.getResponseCode();
		System.out.println("GET Response Code :: " + responseCode);
		if (responseCode == HttpURLConnection.HTTP_OK) { // success
			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();

			// print result
			return response;
			}
		return null;
	}
	
	
	

}
