package com.hemebiotech.analytics;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map.Entry;
import java.util.TreeMap;

public class WriteSortedSymptomsToFile {
	private TreeMap<String, Integer> symptomAndOccurrencesMap;
	private String filepath;

	public WriteSortedSymptomsToFile(TreeMap<String, Integer> symptomAndOccurrencesMap, String filepath) {
		this.symptomAndOccurrencesMap = symptomAndOccurrencesMap;
		this.filepath = filepath;
	}

	public void saveSortedSymptoms() {
		File fileOut = new File(filepath);
		BufferedWriter writer = null;

		try {
			writer = new BufferedWriter(new FileWriter(fileOut));

			for (Entry<String, Integer> entry : symptomAndOccurrencesMap.entrySet()) {
				writer.write(entry.getKey() + ": " + entry.getValue());
				writer.newLine();
			}
			writer.close();
		}

		catch (IOException e) {
			e.printStackTrace();
		}
	}
}
