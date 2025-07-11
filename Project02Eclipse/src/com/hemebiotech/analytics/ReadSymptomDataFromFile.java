package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Interface implementation to get symptoms in the file.
 */

public class ReadSymptomDataFromFile implements ISymptomReader {

	private static Logger logger = LogManager.getLogger(ReadSymptomDataFromFile.class);

	private String filepath;

	/**
	 * Constructor for the file.
	 * 
	 * @param filepath a full or partial path to file with symptom strings in it,
	 *                 one per line.
	 */

	public ReadSymptomDataFromFile(String filepath) {
		this.filepath = filepath;
	}

	@Override
	public List<String> getSymptoms() {
		ArrayList<String> result = new ArrayList<String>();

		if (filepath != null) {
			try {
				BufferedReader reader = new BufferedReader(new FileReader(filepath));
				String line = reader.readLine();

				while (line != null) {
					result.add(line);
					line = reader.readLine();
					System.out.println("Symptom from file: " + line);

				}
				reader.close();
			} catch (IOException e) {
				logger.error("Unable to read the file.");
			}
		}
		return result;
	}
}
