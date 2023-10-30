package com.hemebiotech.analytics;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Manage reader and writer of symptoms.
 */
public class AnalyticsCounter {

	public static ISymptomReader reader;
	public static ISymptomWriter writer;

	public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer) {
		AnalyticsCounter.reader = reader;
		AnalyticsCounter.writer = writer;
	}

	/**
	 * Get symptoms from a file.
	 * 
	 * @param filepath a full or partial path to file with symptom strings in it,
	 *                 one per line.
	 * @return a list of symptom strings, that may contain many duplications.
	 */
	public static List<String> getSymptoms() {
		return AnalyticsCounter.reader.getSymptoms();
	}

	/**
	 * Count the occurrences of each existing symptom.
	 * 
	 * @param a list of symptom strings, that may contain many duplications.
	 * @return a map containing the symptoms and their quantities.
	 */
	public Map<String, Integer> countSymptoms(List<String> symptoms) {
		Map<String, Integer> countsBySymptom = new HashMap<>();
		for (String symp : symptoms) {
			countsBySymptom.put(symp, countsBySymptom.getOrDefault(symp, 0) + 1);
		}
		return countsBySymptom;
	}

	/**
	 * Sort the list of symptoms and occurrences in alphabetical order.
	 * 
	 * @param a map containing the symptoms and their quantities.
	 * @return an alphabetically sorted map containing the symptoms and their
	 *         quantities.
	 */
	public Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms) {
		return new TreeMap<>(symptoms);
	}

	/**
	 * Write the symptoms and their quantities in a result.out file.
	 * 
	 * @param a map containing the symptoms and their quantities.
	 */
	public static void writeSymptoms(Map<String, Integer> symptoms) {
		AnalyticsCounter.writer.writeSymptoms(symptoms);
	}
}