package com.hemebiotech.analytics;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class CreateAndWriteResultToFile implements ISymptomPostProcesser {

	final static String outputFilePath = "/Users/remax/OneDrive/Documents/openclassrooms/developpeur-java/projet2/Project_DA_Java_EN_Come_to_the_Rescue_of_a_Java_Application_with_git/Project02Eclipse/results.txt";

	@Override
	public void WriteToFile(Map<String, Integer> sortedSymptoms) {

		File file = new File(outputFilePath);

		BufferedWriter writer = null;

		try {
			writer = new BufferedWriter(new FileWriter(file));
			for (Map.Entry<String, Integer> entry : sortedSymptoms.entrySet()) {
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

}
