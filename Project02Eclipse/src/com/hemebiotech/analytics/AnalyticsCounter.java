package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

/**
 * Simple brute force implementation
 *
 */
public class AnalyticsCounter implements ISymptomReader {
	// proprieties
	private String filepath; // attributs
	private String resultsfilepath;

	public AnalyticsCounter(String filePath, String resultsFilepath) {
		this.setFilepath(filePath);
		this.setResultsfilepath(resultsFilepath);
	}

	// getter filepath
	public String getFilepath() {
		return filepath;
	}

	// setter filepath
	public void setFilepath(String filePath) {
		this.filepath = filePath;
	}

	// getter resultsfilepath
	public String getResultsfilepath() {
		return resultsfilepath;
	}

	// setter resultsfilepath
	public void setResultsfilepath(String resultsFilePath) {
		this.resultsfilepath = resultsFilePath;
	}

	@Override
	public TreeMap<String, Integer> getSymptomsOccurences() { // getter

		TreeMap<String, Integer> symptomReader = new TreeMap<>(); // initialisation d'une nouvelle Map

		if (this.filepath != null) {
			try (BufferedReader reader = new BufferedReader(new FileReader(this.filepath));) {
				String line = reader.readLine();
				while (line != null) {

					if (symptomReader.containsKey(line)) {
						symptomReader.put(line, symptomReader.get(line) + 1);
					} else {
						symptomReader.put(line, 1);
					}

					line = reader.readLine();
				}
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
		return symptomReader;
	}

	@Override
	public void setMapToFile(TreeMap<String, Integer> symptomOccurence, String resultsFilePath) {

		try (FileWriter writer = new FileWriter(resultsFilePath); BufferedWriter result = new BufferedWriter(writer);) {
			File file = new File(resultsFilePath);
			if (!file.exists()) {
				file.createNewFile();
			}
			for (Map.Entry mapentry : symptomOccurence.entrySet()) {
				result.write(mapentry.getKey() + " " + mapentry.getValue() + "\n");
			}
			result.flush();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
}