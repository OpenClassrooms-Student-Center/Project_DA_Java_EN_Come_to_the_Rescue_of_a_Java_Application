package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class AnalyticsCounter {

	public static void main(String[] args) {
		// first get input
		BufferedReader reader = null;
		File file = new File("symptoms.txt");
		try {
			reader = new BufferedReader(new FileReader(file));
		} catch (FileNotFoundException e) {
			System.err.printf("The file %s was not found.", file.toString());
			System.exit(-1);
		}

		// count occurrences of each symptom
		Map<String, Integer> symptomsCounts = new TreeMap<String, Integer>();

		String line = null;
		try {
			line = reader.readLine();
			while (line != null) {
				System.out.println("Processing line: " + line);

				if (line == null || line.trim().equals("")) {
					continue;
				}
				String processed = line.toLowerCase();

				if (symptomsCounts.containsKey(processed)) {
					symptomsCounts.put(processed, symptomsCounts.get(processed) + 1);
				} else {
					symptomsCounts.put(processed, 1);
				}
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
