package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

/**
 * Simple brute force implementation
 *
 */
public class ReadSymptomDataFromFile implements ISymptomReader {

	private String filepath;

	/**
	 * Reads file with list of symptoms line by line as reported by patients
	 * 
	 * @param filepath a full or partial path to file with symptom strings in it,
	 *                 one per line
	 * 
	 */
	// Constructor
	public ReadSymptomDataFromFile(String filepath) {
		// Initialize file path
		this.filepath = filepath;

	}

	/**
	 * 
	 * @return list of symptom strings read from file
	 */

	// camelCase : getSymptoms instead of GetSymptoms
	public ArrayList<String> getSymptoms() {

		ArrayList<String> result = new ArrayList<String>();

		if (filepath != null) {
			try {

				// Create bufferedReader using fileReader with file path as argument
				BufferedReader reader = new BufferedReader(new FileReader(filepath));

				// Read line
				String line = reader.readLine();

				// Add line to array list and read next until next line is null
				while (line != null) {
					result.add(line);
					line = reader.readLine();
				}
				// close reader
				reader.close();
			} catch (Exception e) {
				e.printStackTrace();
				// return
			}
		}
		// Return consolidated list of symptoms
		return result;
	}
	/**
	 * 
	 * @Override public List<String> GetSymptoms() { return null; }
	 */
}