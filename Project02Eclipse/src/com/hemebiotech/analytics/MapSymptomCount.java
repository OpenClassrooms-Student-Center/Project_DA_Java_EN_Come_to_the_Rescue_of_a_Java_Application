package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Takes a list of symptoms and counts the occurrences of each elements.
 * 
 * @author Yassine PAYET
 *
 */

public class MapSymptomCount {
	/**
	 * Counts occurrences of each different symptoms of a list.
	 * 
	 * @param symptoms
	 * 
	 * @return A map of symptoms in natural order and their occurrences as values.
	 * 
	 * @author Yassine PAYET
	 */

	public static Map<String, Integer> mapSymptom(List<String> symptoms) {

		Map<String, Integer> symptomMap = new TreeMap<>();

		if (symptoms != null && !symptoms.isEmpty()) {

			for (String symptom : symptoms) {
				symptomMap.put(symptom, symptomMap.containsKey(symptom) ? symptomMap.get(symptom) + 1 : 1);
			}
			System.out.println("Analysis -> Ok");
		}

		return symptomMap;

	}
}
