package com.hemebiotech.analytics;

import java.util.List;

public class AnalyticsCounter {

	public static void main(String args[]) throws Exception {
		/**
		 * First get input
		 */
		ReadSymptomDataFromFile reader = new ReadSymptomDataFromFile("Project02Eclipse/symptoms.txt");
		WriteSymptomDataToFile writer = new WriteSymptomDataToFile("Project02Eclipse/result.out");
		NumberOfOccurrences occurrence = new NumberOfOccurrences();

		/**
		 * List of Symptoms
		 */
		List<String> symptomsList = reader.GetSymptoms();

		/**
		 * Print ordered symptoms and their occurrences number
		 */
		writer.SetSymptoms(occurrence.getNumberOccurrences(symptomsList));

	}

}
