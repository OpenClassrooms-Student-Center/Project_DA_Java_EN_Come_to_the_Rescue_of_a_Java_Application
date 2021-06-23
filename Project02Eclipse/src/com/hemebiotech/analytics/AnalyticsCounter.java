package com.hemebiotech.analytics;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AnalyticsCounter {

	public static void main(String args[]) throws Exception {
		// first get input
		ReadSymptomDataFromFile reader = new ReadSymptomDataFromFile("Project02Eclipse/symptoms.txt");
		WriteSymptomDataToFile writer = new WriteSymptomDataToFile("Project02Eclipse/result.out");
		NumberOfOccurrences occurrence = new NumberOfOccurrences();
		
		/**
		 * List of Symptoms
		 */
		List<String> symptomsList = reader.GetSymptoms();
		Set<String> symptoms = new HashSet<String>(symptomsList);
		writer.SetSymptoms(symptomsList,occurrence.getNumberOccurrences(symptoms, symptomsList));
		
//		System.out.println(symptomsList);
//		System.out.println(symptoms);	
		


	}

}
