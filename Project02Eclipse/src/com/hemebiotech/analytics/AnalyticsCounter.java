package com.hemebiotech.analytics;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class AnalyticsCounter {

	/**
	 * This method returns a raw, a hashmap with the symptoms as key and its
	 * occurrence as value
	 * 
	 * @param listSymptoms list of symptoms
	 * 
	 * @return Map<String, Integer> list of symptoms (key: symptom and value:
	 *         occurrence of the symptom
	 */
	public Map<String, Integer> countSymptoms(List<String> listSymptoms) {
		Map<String, Integer> symptoms = new HashMap<>();

		Integer count = 0;

		for (String str : listSymptoms) {
			if (symptoms.containsKey(str)) { // is true if hashmap symptoms contains the symptom (key) from the list
												// listSymptoms
				count = symptoms.get(str) + 1; // increment count if the symptom is already in the hashmap symptoms
				symptoms.put(str, count); // update the count of symptom (value) for the symptom (key)
			} else {
				count = 1; // if the symptom is unknown, the symptom is put in the hashmap as a key with
							// the value 1 (first occurrence)
				symptoms.put(str, count);
			}
		}
		return symptoms;
	}

	/**
	 * This method returns a raw sorted by alphabetic order from an another raw
	 * unsorted
	 * 
	 * @param symptoms raw with symptoms (key) and occurrence (value)
	 * @return Map<String, Integer> list of symptoms sorted by alphabetic order
	 *         (key: symptom and value: occurrence of the symptom
	 */
	public Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms) {
		Map<String, Integer> sortedList = new TreeMap<>(symptoms); // Treemap allows to sort the list of symptoms
		sortedList.putAll(symptoms); // put the key-value in a raw sortedList from the raw TreeMap (use to sort the
										// key symptom
		return sortedList;
	}

}
