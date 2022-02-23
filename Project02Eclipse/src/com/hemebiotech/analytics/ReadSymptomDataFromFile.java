package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *this class allows you to generate a String List from its Method
 *
 */
public class ReadSymptomDataFromFile implements ISymptomReader {

	private String filepath;

	/**
	 * @author HEDOT
	 * @since 25/01/2022
	 * @param filepath a full or partial path to file with symptom strings in it,
	 *                 one per line
	 */
	public ReadSymptomDataFromFile(String filepath) {
		this.filepath = filepath;
	}
	/**
	 * @return an unordered String List with duplicates
	 */
	@Override
	public List<String> getSymptoms() throws IOException {
		

		List<String> result = new ArrayList<String>();
		BufferedReader reader = new BufferedReader(new FileReader(filepath));
		String line = reader.readLine();

		if (filepath != null) {

			try {

				while (line != null) {
					result.add(line);
					line = reader.readLine();
				}

			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				reader.close();
			}
		}

		return result;
	}

}
