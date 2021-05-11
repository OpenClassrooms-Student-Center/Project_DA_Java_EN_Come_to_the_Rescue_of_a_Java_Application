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
public class SymptomFileReader implements ISymptomReader {

	public static String DEFAULT_FILENAME_IN = "symptoms.txt";
	private String filepath;
	
	/**
	 * 
	 * @param filepath a full or partial path to file with symptom strings in it, one per line
	 */
	public SymptomFileReader (String filepath) {
		
		this.filepath = filepath;
	}
	
	
	@Override
	public List<String> GetSymptoms() {
		ArrayList<String> result = new ArrayList<String>();
		
		if (filepath != null) {
			
			try {
				
				System.out.println("Trying to read symptoms from this file: " + this.filepath);
				
				BufferedReader reader = new BufferedReader (new FileReader(filepath));
				String line = reader.readLine();
				
				while (line != null) {
					result.add(line);
					line = reader.readLine();
				}
				reader.close();
			} catch (IOException e) {
				System.out.println("An error occured while trying to read symptoms file. See below");
				e.printStackTrace();
			}
		}
		
		System.out.println("The number of symptoms (may be duplicate) found is : " + result.size() );
		
		return result;
	}

}
