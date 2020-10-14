package com.hemebiotech.analytics;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.TreeMap;

/**
 * Date: Oct 14-2020. This is a simple application for counting occurrences of
 * symptoms listed in a file.
 * 
 * @author adrien
 * @version 2.0
 *
 */
public class AnalyticsCounter {

	public static void main(String[] args) {

		SymptomCounter symptomCounter = new SymptomCounter("symptoms.txt");
		TreeMap<String, Integer> symptomsCounts = symptomCounter.getSymptomOccurrences();

		// next generate output
		BufferedWriter writer = null;
		File file2 = new File("symptom_occurrence.out");
		try {
			writer = new BufferedWriter(new FileWriter(file2));

			for (String symptom : symptomsCounts.keySet()) {
				int count = symptomsCounts.get(symptom);
				writer.write(symptom + " : " + count);
				writer.newLine();
			}

		} catch (IOException e) {
			System.err.printf("Impossible to write in the file %s.", file2.toString());
			System.exit(-1);
		}
		try {
			writer.close();
		} catch (IOException e) {
			System.err.printf("The file %s cannot be closed.", file2.toString());
			System.exit(-1);
		}
	}
}
