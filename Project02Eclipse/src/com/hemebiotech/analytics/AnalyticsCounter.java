package com.hemebiotech.analytics;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class AnalyticsCounter {
	private ISymptomReader reader;
	private ISymptomWriter writer;

	public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer) {
		this.reader = reader;
		this.writer = writer;
	}

	public List<String> getSymptoms() {
		return this.reader.getSymptoms();
	}

	public Map<String, Integer> countSymptoms(List<String> symptoms) {
		Map<String, Integer> countMap = new HashMap<>();

		for (String symptom : symptoms) {
			countMap.computeIfAbsent(symptom, s -> 1);
			countMap.put(symptom, countMap.get(symptom) + 1);
		}

		return countMap;
	}

	public Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms) {
		return new TreeMap<>(symptoms);
	}

	public void writeSymptoms(Map<String, Integer> symptoms) {
		this.writer.writeSymptoms(symptoms);
	}
}
