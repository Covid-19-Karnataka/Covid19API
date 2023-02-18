package com.api.CvdKtkApi.ScheduledTriggers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.stereotype.Component;

@Component
public class PythonScriptExecuter {
	
	public void PythonExec(String filePath)
	{
		try {
            // Specify the path to the Python script to run
            String scriptPath = "src/main/java/com/api/CvdKtkApi/PythonScripts/test.py";

            // Create a new process builder for the Python interpreter and script
            ProcessBuilder processBuilder = new ProcessBuilder("python", scriptPath, "");

            // Start the process and wait for it to finish
            Process process = processBuilder.start();
            int exitCode = process.waitFor();

            // Print the output of the script to the console
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            // Check the exit code of the process to see if it completed successfully
            if (exitCode == 0) {
                System.out.println("Python script completed successfully");
            } else {
                System.err.println("Python script failed with exit code " + exitCode);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
	}

}
