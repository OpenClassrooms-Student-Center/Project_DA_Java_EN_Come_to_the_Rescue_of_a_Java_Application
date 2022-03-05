package com.hemebiotech.analytics;

import java.util.List;
import java.util.TreeMap;

public class SortSymptomsData {

	/**
	 * @return a sorted list of counted symptoms
	 * 
	 */

	public TreeMap<String, Integer> sortingSymptomsData() {

		// Call Reading class with file path as argument
		ReadSymptomDataFromFile file = new ReadSymptomDataFromFile("Project02Eclipse/symptoms.txt");
		file.getSymptoms();

		List<String> symptomsFile = file.getSymptoms();

		// Create treemap
		TreeMap<String, Integer> symptomsSorting = new TreeMap<>();

		// Add symptom as key if not already in treemap and add +1 to value or add 1 to
		// value if it is already in
		for (String listSymptoms : symptomsFile) {
			if (symptomsSorting.containsKey(listSymptoms)) {
				symptomsSorting.put(listSymptoms, symptomsSorting.get(listSymptoms) + 1);
			} else {
				symptomsSorting.put(listSymptoms, 1);
			}

		}
		// Output is list of symptoms with related count for each symptom
		return symptomsSorting;
	}
}