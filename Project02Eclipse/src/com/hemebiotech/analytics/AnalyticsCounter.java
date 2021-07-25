package com.hemebiotech.analytics;

import java.util.List;

public class AnalyticsCounter {

	public static void main(String args[]) throws Exception {
		/**
		 * First get input
		 */
		ISymptomReader reader = new ReadSymptomDataFromFile("Project02Eclipse/symptoms.txt");
		ISymptomWriter writer = new WriteSymptomDataToFile("Project02Eclipse/result.out");
		IOccurrencesCount occurrence = new CountOfOccurrences();

		/**
		 * List of Symptoms
		 */
		List<String> symptomsList = reader.getSymptoms();

		/**
		 * Print ordered symptoms and their occurrences number
		 */
		
		writer.setSymptoms(occurrence.getNumberOccurrences(symptomsList));

	}

}
