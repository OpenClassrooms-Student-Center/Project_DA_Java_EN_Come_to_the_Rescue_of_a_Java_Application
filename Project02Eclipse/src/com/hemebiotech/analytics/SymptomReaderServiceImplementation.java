package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

/**
 * Simple brute force implementation
 *
 */
public class SymptomReaderServiceImplementation implements ISymptomReaderService {

	private String filepath;
	
	/**
	 * 
	 * @param filepath a full or partial path to file with symptom strings in it, one per line
	 */
	public SymptomReaderServiceImplementation(String filepath) {
		this.filepath = filepath;
	}
	
	@Override
	public HashMap<String, Integer> getSymptoms() throws IOException {
		BufferedReader reader = new BufferedReader (new FileReader("symptoms.txt"));
		String line = reader.readLine();

		HashMap<String, Integer> symptoms = new HashMap<>();
		int i = 0;	// set i to 0
		while (line != null) {
			i++;	// increment i
			System.out.println("symptom from file: " + line);

			if (symptoms.containsKey(line)) {
				symptoms.put(line, symptoms.get(line)+1);
			} else {
				symptoms.put(line, 1);
			}

			line = reader.readLine();	// get another symptom
		}
		
		return symptoms;
	}

}
