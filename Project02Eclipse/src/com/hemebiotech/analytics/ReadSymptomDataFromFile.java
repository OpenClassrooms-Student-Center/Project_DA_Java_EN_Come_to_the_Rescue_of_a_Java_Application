package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Simple brute force implementation
 *
 */
public class ReadSymptomDataFromFile implements ISymptomReader {

	private String filePath;

	/**
	 * @param filePath a full or partial path to file with symptom strings in it,
	 *                 one per line.
	 */
	public ReadSymptomDataFromFile(String filepath) {
		this.filePath = filepath;
	}

	@Override
	public List<String> getSymptoms() {

		ArrayList<String> symptomsList = new ArrayList<>();

		if (filePath != null) {

			try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
				String line = reader.readLine();

				while (line != null) {
					symptomsList.add(line);
					line = reader.readLine();
				}

			} catch (IOException e) {
				System.err.println("Error while reading file " + e.getMessage() + " caused by " + e.getCause());
			}

		}

		return symptomsList;
	}
}
