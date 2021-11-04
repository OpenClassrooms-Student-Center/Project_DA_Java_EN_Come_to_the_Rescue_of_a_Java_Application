package com.hemebiotech.analytics;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class GenerateOutput  {


	final static String outputFilePath = "/Project02Eclipse/result.out";

	public void WriteToFile(Map<String, Integer> writeSymptoms) {

		File file = new File(outputFilePath);

		BufferedWriter writer = null;

		try {
			writer = new BufferedWriter(new FileWriter(file));
			for (Map.Entry<String, Integer> entry : writeSymptoms.entrySet()) {
				writer.write(entry.getKey() + ": " + entry.getValue());
				writer.newLine();
			}

			writer.flush();
			System.out.println("File created: " + file.getName());
			System.out.println("Absolute path: " + file.getAbsolutePath());
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		} finally {

			try {
				writer.close();
			} catch (Exception e) {
			}
		}
	}

	
	

	public void writeSymptoms(Map<String, Integer> mapCounted) {
		// TODO Auto-generated method stub
		
	}

}