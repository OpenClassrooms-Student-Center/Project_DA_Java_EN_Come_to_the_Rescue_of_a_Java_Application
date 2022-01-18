package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Read symptoms file
 */
public class ReadSymptomDataFromFile implements ISymptomReader {

	private String filepath;
	
	/**
	 * @name: ReadSymptomDataFromFile
	 * @description: create an objet whith the filepath
	 * @param filepath a full or partial path to file with symptom strings in it, one per line
	 */
	public ReadSymptomDataFromFile (String filepath) {
		this.filepath = filepath;
	}

	/**
	 * @name: GetSymptoms
	 * @description: read the file of symptoms
	 * @param no input
	 * Format of records: name of symptoms
	 */
	@Override
	public List<String> GetSymptoms() {
		ArrayList<String> result = new ArrayList<String>();
		
		if (filepath != null) {
			FileReader fileReader = null;
			try {
				fileReader = new FileReader(filepath);
				BufferedReader reader = new BufferedReader (fileReader);
				String line = reader.readLine();
				
				while (line != null) {
					result.add(line);
					line = reader.readLine();
				}
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					if (fileReader != null) {
						fileReader.close();
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		return result;
	}

}