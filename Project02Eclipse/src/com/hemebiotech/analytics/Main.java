package com.hemebiotech.analytics;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * The main class for analyzing and processing symptom data.
 */
public class Main {
	public static void main(String[] args) throws IOException {
		ISymptomReader reader = new ReadSymptomDataFromFile("symptoms.txt");
		ISymptomWriter writer = new WriteSymptomDataToFile("result.out");
		AnalyticsCounter counter = new AnalyticsCounter(reader, writer);

		List<String> symptoms = counter.getSymptoms();
		Map<String, Integer> sortedCount = counter.sortSymptoms(counter.countSymptoms(symptoms));

		counter.writeSymptoms(sortedCount);
	}
}
