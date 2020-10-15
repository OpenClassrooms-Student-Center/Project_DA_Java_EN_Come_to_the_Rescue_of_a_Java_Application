package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Date: Oct 15-2020. This class read the symptoms in a file.
 * 
 * @author adrien
 * @version 2.0
 */
public class ReadSymptomDataFromFile implements ISymptomReader {

	private String filepath;
	private List<String> symptomsList = null;

	/**
	 * 
	 * @param filepath a full or partial path to file with symptom strings in it,
	 *                 one per line
	 */
	public ReadSymptomDataFromFile(String filepath) {
		this.filepath = filepath;
		symptomsList = new ArrayList<String>();
	}

	/**
	 * Read symptoms in a file and write them in a list
	 * 
	 * @return a List of String of symptoms
	 */
	public List<String> GetSymptoms() {
		BufferedReader reader = null;
		File file = new File(filepath);
		try {
			reader = new BufferedReader(new FileReader(file));
		} catch (FileNotFoundException e) {
			System.err.printf("The file %s was not found.", file.toString());
			System.exit(-1);
		}
		String line = null;
		try {
			line = reader.readLine();
			while (line != null) {
				System.out.println("Processing line: " + line);

				if (line == null || line.trim().equals("")) {
					continue;
				}
				String processed = line.toLowerCase();

				symptomsList.add(processed);

				line = reader.readLine(); // get another symptom
			}
		} catch (IOException e) {
			System.err.printf("The file %s cannot be read.", file.toString());
			System.exit(-1);
		}
		try {
			reader.close();
		} catch (IOException e1) {
			System.err.printf("The file %s cannot be closed.", file.toString());
			System.exit(-1);
		}
		return symptomsList;
	}

}
