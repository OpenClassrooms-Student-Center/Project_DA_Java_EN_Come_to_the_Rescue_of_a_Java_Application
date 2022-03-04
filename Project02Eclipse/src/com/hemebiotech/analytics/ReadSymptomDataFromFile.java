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
	// constructor
	public ReadSymptomDataFromFile(String filepath) {
		// Initialize attribute filepath
		this.filepath = filepath;

	}

	public List<String> getSymptoms() {

		ArrayList<String> result = new ArrayList<String>();

		if (filepath != null) {
			try {

				// Create bufferedReader using fileReader using filepath as argument
				BufferedReader reader = new BufferedReader(new FileReader(filepath));

				// Read next line
				String line = reader.readLine();

				// Add line to array list and read next line until next line is not null
				while (line != null) {
					result.add(line);
					line = reader.readLine();
				}
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
				// return
			}
		}
		// Return consolidated list of symptoms
		return result;
	}

	@Override
	public List<String> GetSymptoms() {
		return null;
	}

}