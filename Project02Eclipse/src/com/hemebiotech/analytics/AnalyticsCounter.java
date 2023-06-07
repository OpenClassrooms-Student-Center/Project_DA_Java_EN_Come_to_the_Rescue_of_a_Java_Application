package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

public class AnalyticsCounter {

	public static void main(String args[]) throws Exception {

		BufferedReader reader = new BufferedReader(new FileReader(".\\Project02Eclipse\\symptoms.txt"));
		String line = reader.readLine();
		WriteSymptomDataToFile writeSymptoms = new WriteSymptomDataToFile();
		Map<String, Integer> symptoms = new HashMap<>();

		int i = 0;
		String symptom;
		Integer countSymptom = 0;
		// read the file symptoms.txt and put the values in a hashmap (called symptoms)

		while (line != null) {
			// i++;
			if (symptoms.containsKey(line)) { // is true if hashmap contains the symptom from the list symptoms.txt /
												// increment to the count
				countSymptom = symptoms.get(line) + 1;
				symptoms.put(line, countSymptom);
			} else {
				countSymptom = 1;
				symptoms.put(line, countSymptom);
			}
			line = reader.readLine(); // get another symptom
		}

		writeSymptoms.writeSymptoms(symptoms);

		// writeSymptoms(Map < String, Integer > symptoms);
		// next generate output
		/*
		 * FileWriter writer = new FileWriter("result.out"); writer.write("headache: " +
		 * headacheCount + "\n"); writer.write("rash: " + rashCount + "\n");
		 * writer.write("dialated pupils: " + pupilCount + "\n"); writer.close();
		 */
	}
}
