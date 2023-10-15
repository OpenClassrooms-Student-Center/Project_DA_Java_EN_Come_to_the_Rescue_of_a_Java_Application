package com.hemebiotech.analytics;

/**
 * 
 * @author AMP2024
 * @version
 * 
 *          Class that contains the main method.
 */
public class Main {

	public static void main(String[] args) {

		ISymptomReader reader = new ReadSymptomDataFromFile();

		ISymptomWriter writer = new WriteSymptomDataToFile();

		AnalyticsCounter symptoms = new AnalyticsCounter(reader, writer);

		symptoms.unsortedList = reader.getSymptoms();

		symptoms.symptomsMap = symptoms.countSymptoms(symptoms.unsortedList);

		symptoms.symptomsMap = symptoms.sortSymptoms(symptoms.symptomsMap);

		symptoms.writer.writeSymptoms(symptoms.symptomsMap);

	}
}
