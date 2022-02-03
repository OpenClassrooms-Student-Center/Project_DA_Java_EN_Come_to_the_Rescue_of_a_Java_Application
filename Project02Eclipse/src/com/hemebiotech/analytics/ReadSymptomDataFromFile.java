package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Simple brute force implementation
 *
 */
public class ReadSymptomDataFromFile implements ISymptomReader {

	public static final String MESSAGE_FILE_NOT_FOUND = "No file in found symptoms.txt";
	public static final String MESSAGE_OTHER_IO_ERROR = "Reading issue with the file in symptoms.txt";
	public static final String MESSAGE_FILE_CLOSE_ERROR = "File in not closed";

	private String filepath;
	
	/**
	 * 
	 * @param filepath a full or partial path to file with symptom strings in it, one per line
	 */
	public ReadSymptomDataFromFile (String filepath) {
		this.filepath = filepath;
	}
	
	@Override
	public ArrayList<String> GetSymptoms() {

		ArrayList<String> result = new ArrayList<String>();
		BufferedReader reader = null;
		
		if (filepath != null) {
			try {
				reader = new BufferedReader(new FileReader(filepath));
				String line = reader.readLine();
				
				while (line != null) {
					result.add(line);
					line = reader.readLine();
				}
			} catch (FileNotFoundException e) {
				System.out.println(MESSAGE_FILE_NOT_FOUND);
				System.exit(-1);
			} catch (IOException e) {
				System.out.println(MESSAGE_OTHER_IO_ERROR);
				System.exit(-1);
			} finally {
				if (reader != null) {
					try {
						reader.close();
					} catch (IOException f) {
						System.out.println(MESSAGE_FILE_CLOSE_ERROR);
					}
				}
			}
		}
		
		return result;
	}

}
