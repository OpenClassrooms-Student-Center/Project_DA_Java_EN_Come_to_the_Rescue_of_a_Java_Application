package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Simple brute force implementation
 *
 */
public class AnalyticsCounter implements ISymptomReader {
	// proprieties
	private String filepath; // attributs

	public AnalyticsCounter(String filePath) { // constructeur de la class SymptomReader
		this.setFilepath(filePath);
	}

	// getter
	public String getFilepath() {
		return filepath;
	}

	// setter
	public void setFilepath(String filePath) {
		this.filepath = filePath;
	}

	@Override
	public Map<String, Integer> getSymptomsOccurences() { // getter

		Map<String, Integer> symptomReader = new HashMap<>(); // initialisation d'une nouvelle Map

		if (this.filepath != null) {
			try {
				BufferedReader reader = new BufferedReader(new FileReader(this.filepath));
				String line = reader.readLine();

				while (line != null) {

					if (symptomReader.containsKey(line)) {
						symptomReader.put(line, symptomReader.get(line) + 1);
					} else {
						symptomReader.put(line, 1);
					}
					line = reader.readLine();
				}
				reader.close();

			} catch (IOException e) {
				System.out.println(e.getMessage());
				;
			}
		}
		return symptomReader;
	}

	@Override
	public void setMapToFile(Map<String, Integer> symptomOccurence, String resultFilePath) {

	}
}
