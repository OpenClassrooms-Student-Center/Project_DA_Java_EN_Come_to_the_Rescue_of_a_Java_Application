package com.hemebiotech.analytics;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class AnalyticsCounter {

	ISymptomReader reader;
	ISymptomWriter writer;

	// Constructor of AnalyticsCounter()
	public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer) {
		this.reader = reader;
		this.writer = writer;
	}

	public Map<String, Integer> countSymptoms(List<String> listSymptoms) {
		Map<String, Integer> symptoms = new HashMap<>();

		Integer count = 0;
		// read the file symptoms.txt and put the values in a hashmap (called symptoms)

		for (String str : listSymptoms) {
			if (symptoms.containsKey(str)) { // is true if hashmap contains the symptom from the list symptoms.txt
				count = symptoms.get(str) + 1; // increment if symptom is already in the hashmap
				symptoms.put(str, count); // insert the count of symptom for the symptom
			} else {
				count = 1; // if the symptom is unknown, the symptom is put in the hashmap
				symptoms.put(str, count);
			}
		}
		return symptoms;
	}

	public Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms) {
		Map<String, Integer> sortedList = new TreeMap<>(symptoms); // Treemap allows to sort the list of symptoms
		sortedList.putAll(symptoms);
		return sortedList;
	}

}
