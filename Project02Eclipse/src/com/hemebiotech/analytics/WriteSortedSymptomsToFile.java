package com.hemebiotech.analytics;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map.Entry;
import java.util.TreeMap;

/**
 * @author alex
 * @version 1.0 write (Key + ": " + Value) from a TreeMap to a file, one couple
 *          per line. (key : symptom name value : occurrences number of the
 *          symptom)
 */

public class WriteSortedSymptomsToFile {
	private TreeMap<String, Integer> symptomAndOccurrencesMap;
	private String filepath;

	/**
	 * @param symptomAndOccurrencesMap : extracted data from a file have been
	 *                                 converted in a TreeMap (with Symptoms and
	 *                                 their occurrences)
	 * 
	 * @param filepath                 : path to the file where the TreeMap will be
	 *                                 translated : (1 key + its value) per 1 line
	 */
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

		/**
		 * @throws IOException
		 */
		catch (IOException e) {
			e.printStackTrace();
		}
	}
}
