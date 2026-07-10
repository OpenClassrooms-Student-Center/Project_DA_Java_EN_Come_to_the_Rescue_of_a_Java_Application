package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Simple brute force implementation
 * <p>
 * Reads symptom data from a text file
 * <p>
 * This class implements the {@code ISymptomReader} interface and returns
 * the symptoms contained in a file
 * <p>
 * The input file must contain one symptom per line
 */

public class ReadSymptomDataFromFile implements ISymptomReader {
	
	// Path to the file containing the symptom data, one per line
    private String filepath;
		
	/**
	 * Constructor with parameter
	 * <p>
     * Creates a new reader that reads symptom data from the specified file
     * <p>
     * @param filepath the full or relative path to the file containing
     * one symptom per line
     */
	public ReadSymptomDataFromFile (String filepath) {
		this.filepath = filepath;
	}
	
	/**
     * Reads all symptoms from the input file
     * <p>
     * @return a list containing all the symptoms read from the file;
     * returns an empty list if the file path is {@code null}
     * or if an I/O error occurs
     */
	@Override
	public List<String> GetSymptoms() {
		ArrayList<String> result = new ArrayList<String>();
		if (filepath != null) {
			try {
				BufferedReader reader = new BufferedReader (new FileReader(filepath));
				String line = reader.readLine();
				
				while (line != null) {
					result.add(line);
					line = reader.readLine();
				}
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
}
