package com.hemebiotech.analytics;

import java.util.List;
import java.util.TreeMap;

/**
 * 
 * Create list of symptoms through class ReadSymptomDatafromFile Converted
 * unsorted consolidated list into a treemap
 *
 */

public class SortSymptomsData {

	public TreeMap<String, Integer> sortingSymptomsData() {

		// Call reading class and pass path to file as argument
		ReadSymptomDataFromFile file = new ReadSymptomDataFromFile("Project02Eclipse/symptoms.txt");
		file.getSymptoms();

		List<String> symptomsFile = file.getSymptoms();

		// Creation of a treemap from symptoms list
		TreeMap<String, Integer> symptomsSorting = new TreeMap<>();

		// Add symptom as key if not already in the treemap and add +1 to value or add 1
		// to value if it is
		for (String listSymptoms : symptomsFile) {
			if (symptomsSorting.containsKey(listSymptoms)) {
				symptomsSorting.put(listSymptoms, symptomsSorting.get(listSymptoms) + 1);
			} else {
				symptomsSorting.put(listSymptoms, 1);
			}

		}

		return symptomsSorting;
	}
}
