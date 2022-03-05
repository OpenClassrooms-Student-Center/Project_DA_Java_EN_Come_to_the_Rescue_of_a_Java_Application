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

	private String filepath;

	/**
	 * 
	 * @param filepath a full or partial path to file with symptom strings in it,
	 *                 one per line
	 */

	public ReadSymptomDataFromFile(String filepath) { // constructor

		this.filepath = filepath;

	}

	public List<String> getSymptoms() {
		// Create empty list of undefined number of string to store symptoms
		ArrayList<String> result = new ArrayList<String>();

		if (filepath != null) {
			try {
				// Create Reader to read file from path
				BufferedReader reader = new BufferedReader(new FileReader(filepath));

				String line = reader.readLine();

				// Until line is null add string to list of symptoms
				while (line != null) {
					result.add(line);
					line = reader.readLine();
				}
				reader.close(); // Close Reader
			} catch (IOException e) {
				e.printStackTrace();

			}
		}
		// Return list with consolidated list of symptoms
		return result;
	}

	@Override
	public List<String> GetSymptoms() {
		return null;
	}

}