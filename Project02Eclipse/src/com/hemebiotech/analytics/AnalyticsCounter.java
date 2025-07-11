package com.hemebiotech.analytics;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class AnalyticsCounter {
	ISymptomReader reader;
	ISymptomWriter writer;

	public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer) {
		this.reader = reader;
		this.writer = writer;
	}

	public List<String> getSymptoms() {
		return reader.getSymptoms();
	}

	/**
	 *Count symptoms from the file.
	 *
	 *@return map of counted symptom/value.
	 *@param list of symptoms.
	 */
	
	public Map<String, Integer> countSymptoms(List<String> symptoms) {
		Map<String, Integer> counter = new LinkedHashMap<String, Integer>();
		for (String symptom : symptoms) {
			counter.put(symptom, counter.getOrDefault(symptom, 0) + 1);
		}
		for (Map.Entry<String, Integer> entry : counter.entrySet()) {
			System.out.println(entry.getKey() + ": " + entry.getValue() + " times.");
		}
		return counter;
	}

	/**
	 *Sort symptoms in alphabetical order.
	 *
	 *@return map of symptom/value in alphabetical order.
	 *@param map of counted symptoms.
	 */
	
	public Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms) {
		Map<String, Integer> sorter = new TreeMap<String, Integer>(symptoms);
		System.out.println("Sorting : " + sorter);
		return sorter;
	}

	public void writeSymptoms(Map<String, Integer> symptoms) throws IOException {
		writer.writeSymptoms(symptoms);
	}
}
