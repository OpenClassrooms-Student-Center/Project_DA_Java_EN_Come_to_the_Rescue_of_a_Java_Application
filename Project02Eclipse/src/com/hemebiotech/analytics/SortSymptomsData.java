package com.hemebiotech.analytics;

import java.util.ArrayList;
import java.util.TreeMap;

/**
 * Symptoms data processing to return ordered and counted list of symptoms
 * 
 * @author CHRISTINE TETI
 *
 */
public class SortSymptomsData {
	/**
	 * Counts and sorts symptoms in alphabetical order then generates consolidates
	 * final list
	 * 
	 * @param readsymptoms a list of symptom stings read from file
	 * @return list of sorted and counted symptoms
	 */
	public TreeMap<String, Integer> sortingSymptomsData(ArrayList<String> readsymptoms) {

		// Create empty TreeMap
		TreeMap<String, Integer> symptomsSorting = new TreeMap<>();

		// Add symptom string from list as key if not already in the TreeMap and add 1
		// to value
		// to value or add +1 to existing value the key is already in TreeMap

		if (readsymptoms != null && !readsymptoms.isEmpty()) {
			try {
				for (String listSymptoms : readsymptoms) {
					if (symptomsSorting.containsKey(listSymptoms)) {
						symptomsSorting.put(listSymptoms, symptomsSorting.get(listSymptoms) + 1);
					}

					else {
						symptomsSorting.put(listSymptoms, 1);

					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			// Display no symptoms message
		} else {
			System.out.println("No symptoms !");

		}
		// output ordered and counted symptoms
		return symptomsSorting;
	}
}