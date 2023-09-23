package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

public class Main {
	public static void main(String args[]) {
		ISymptomReader reader = new ReadSymptomDataFromFile("symptoms.txt");
		ISymptomWriter writer = new WriteSymptomDataToFile("result.out");
		AnalyticsCounter counter = new AnalyticsCounter(reader, writer);

		List<String> symptoms = counter.getSymptoms();
		Map<String, Integer> sortedCount = counter.sortSymptoms(counter.countSymptoms(symptoms));

		counter.writeSymptoms(sortedCount);
	}
}
