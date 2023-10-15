package com.hemebiotech.analytics;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

/**
 * @author AMP2024
 * @version
 * 
 *          Class that writes a "result.out" file which contains the list of
 *          symptoms ordered alphabetically and their number of occurrences.
 *          Implements ISYmptomWriter.
 */
public class WriteSymptomDataToFile implements ISymptomWriter {

	private String filepath;

	/**
	 * @param filepath A full or partial path to the file where to write the list of
	 *                 symptoms sorted alphabetically and their occurrences
	 */
	public WriteSymptomDataToFile(String filepath) {
		this.filepath = filepath;
	}

	public WriteSymptomDataToFile() {
		this.filepath = "result.out";
	}

	/**
	 * Used to write in a "result.out" file the list of symptoms classified in
	 * alphabetical order and their number of occurrences, one symptom and its
	 * occurrence per line
	 * 
	 * @param symptoms A Map containing the list of symptoms sorted as keys in
	 *                 strings and their occurrences as values in integers
	 */
	@Override
	public void writeSymptoms(Map<String, Integer> symptoms) {

		if (filepath != null) {

			try {

				BufferedWriter writer = new BufferedWriter(new FileWriter(filepath, false));

				for (Map.Entry<String, Integer> entry : symptoms.entrySet()) {

					writer.write(entry.getKey() + " " + entry.getValue());

					writer.newLine();
				}

				writer.close();

			} catch (IOException e) {
				e.printStackTrace();

			}

		}

	}

}
