package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author AMP2024
 * @version
 * 
 *          Class that takes the "symptoms.txt" file, which will read it to make
 *          a list. Implements ISYmptomReader.
 */
public class ReadSymptomDataFromFile implements ISymptomReader {

	private String filepath;

	/**
	 * @param filepath a full or partial path to file with symptom strings in it,
	 *                 one per line
	 */
	public ReadSymptomDataFromFile(String filepath) {
		this.filepath = filepath;
	}

	public ReadSymptomDataFromFile() {
		this.filepath = "symptoms.txt";
	}

	/**
	 * Used to read the list of symptoms from the "symptoms.txt" file and put it
	 * into a list.
	 * 
	 * @return List<String> A list containing the list of symptoms from the
	 *         "symptoms.txt" file.
	 */
	@Override
	public List<String> getSymptoms() {

		List<String> result = new ArrayList<String>();

		if (filepath != null) {

			try {
				BufferedReader reader = new BufferedReader(new FileReader(filepath));

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
