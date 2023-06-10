package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of ISymptomReader Contains the getSymptoms method
 */
public class ReadSymptomDataFromFile implements ISymptomReader {

	public String filepathReadFile;

	/**
	 * 
	 * @param filepath a full or partial path to file with symptom strings in it,
	 *                 one per line
	 */
	public ReadSymptomDataFromFile(String filepath) {
		this.filepathReadFile = filepath;
	}

	/**
	 * This method returns a List of symptoms unsorted with duplicate symptoms from
	 * a file
	 * 
	 * @exception IOException Exception if the input file is not found
	 * @exception Exception   if an error produced by failed or interrupted I/O
	 *                        operations
	 * @return List<String> list of symptoms (key: symptom and value: occurrence of
	 *         the symptom
	 */
	public List<String> getSymptoms() {
		List<String> result = new ArrayList<String>();

		if (filepathReadFile != null) {
			try {
				BufferedReader reader = new BufferedReader(new FileReader(filepathReadFile));
				String line = reader.readLine();

				while (line != null) {
					result.add(line);
					line = reader.readLine();
				}
				reader.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
}