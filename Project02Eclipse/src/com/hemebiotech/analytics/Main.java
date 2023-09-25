package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;


public class Main {
	/** Main method reads and writes symptoms
	 * @param args
	 */
	public static void main(String[] args) {
		String filepath = "symptoms.txt";
		ISymptomReader reader = new ReadSymptomDataFromFile(filepath);
		ISymptomWriter writer = new WriteSymptomDataToFile();

		AnalyticsCounter count = new AnalyticsCounter(reader, writer);
		List<String> symptoms = count.getSymptoms();
		Map<String, Integer> mapSymptoms = count.countSymptoms(symptoms);
		Map<String, Integer> mapSymptomsSorted = count.sortSymptoms(mapSymptoms);

		count.writeSymptoms(mapSymptomsSorted);
	}
}
