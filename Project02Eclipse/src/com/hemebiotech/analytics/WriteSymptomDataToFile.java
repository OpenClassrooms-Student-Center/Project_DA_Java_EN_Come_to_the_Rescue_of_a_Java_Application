package com.hemebiotech.analytics;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Interface implementation to write to the file after sorting the list of
 * symptoms retrieved from the file.
 */

public class WriteSymptomDataToFile implements ISymptomWriter {

	private String filepath;

	private static Logger logger = LogManager.getLogger(WriteSymptomDataToFile.class);

	/**
	 * Constructor for the file.
	 * 
	 * @param filepath a full or partial path to output file including symptom
	 *                 strings in alphabetical order and their values.
	 * 
	 */

	public WriteSymptomDataToFile(String filepath) {
		this.filepath = filepath;
	}

	@Override
	public void writeSymptoms(Map<String, Integer> symptoms) throws IOException {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(filepath))) {
			for (Map.Entry<String, Integer> entry : symptoms.entrySet()) {
				writer.write(entry.getKey() + ": " + entry.getValue());
				writer.newLine();
			}

		} catch (IOException e) {
			logger.error("Unable to write in the file.");
		}
	}
}
