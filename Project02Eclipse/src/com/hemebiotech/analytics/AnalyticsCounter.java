package com.hemebiotech.analytics;

import java.util.List;
import java.util.Set;

public class AnalyticsCounter {

	public static void main(String args[]) throws Exception {
		// first get input
		ReadSymptomDataFromFile reader = new ReadSymptomDataFromFile("Project02Eclipse/symptoms.txt");
		WriteSymptomDataToFile writer = new WriteSymptomDataToFile("Project02Eclipse/result.out");

		/**
		 * List of Symptoms
		 */
		List<String> symptomsList = reader.GetSymptoms();
		Set<String> symptoms = writer.SetSymptoms(symptomsList);

		
		
		System.out.println(symptomsList);
		System.out.println(symptoms);
		
		


	}

}
