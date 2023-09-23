package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.util.Map;

/**
 * This class implements the ISymptomWriter interface to write symptoms and
 * their frequencies to a file.
 */
public class WriteSymptomDataToFile implements ISymptomWriter {

	private String filepath;

	/**
	 * Constructor for the WriteSymptomDataToFile class.
	 *
	 * @param filepath The path to the file where symptoms will be written.
	 */
	public WriteSymptomDataToFile(String filepath) {
		this.filepath = filepath;
	}

	/**
	 * Writes symptoms and their frequencies to the specified file.
	 *
	 * @param symptoms An object of type Map where keys are symptoms and values are
	 *                 their frequencies.
	 */
	@Override
	public void writeSymptoms(Map<String, Integer> symptoms) {
		try (FileWriter writer = new FileWriter(filepath)) {
			for (Map.Entry<String, Integer> symptom : symptoms.entrySet()) {
				writer.write(symptom.getKey() + ": " + symptom.getValue() + "\n");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
