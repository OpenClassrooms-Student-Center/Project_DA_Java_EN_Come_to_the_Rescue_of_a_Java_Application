package com.hemebiotech.analytics.analytics.reader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Simple brute force implementation
 *
 */
public class SymptomReader implements ISymptomReader {

	private final String filepath; // File to read.
	private final List<String> symptoms; // Raw list of symptoms
	
	/**
	 * 
	 * @param filepath a full or partial path to file with symptom strings in it, one per line
	 */
	public SymptomReader(String filepath) {
		this.filepath = filepath;
		this.symptoms = new ArrayList<>();
	}
	
	@Override
	public void read() {
		if (filepath != null) {
			this.symptoms.clear(); //Clear symptoms before.

			try {
				BufferedReader reader = new BufferedReader(new FileReader(filepath)); // Create BufferedReader.
				String line = reader.readLine(); // Set first line to read.

				while (line != null) {
					this.symptoms.add(line); // Add current line int List.
					line = reader.readLine(); // Set next line.
				}
				reader.close(); // Close the reader.
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public List<String> getSymptoms() {
		return this.symptoms;
	}
}
