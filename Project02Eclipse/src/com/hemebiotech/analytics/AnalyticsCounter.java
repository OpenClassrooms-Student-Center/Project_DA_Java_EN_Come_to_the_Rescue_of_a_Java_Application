package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.util.HashMap;

public class AnalyticsCounter {

	public static ISymptomReaderService symptomReaderService = new SymptomReaderServiceImplementation("");
	
	public static void main(String args[]) throws Exception {
		// first get input
		HashMap<String, Integer> symptoms = new HashMap<>();
		symptoms = symptomReaderService.getSymptoms();

		// next generate output
		FileWriter writer = new FileWriter ("result.out");
		for (String s: symptoms.keySet()) {
			writer.write(s + " : " + symptoms.get(s) + "\n");
		}
		writer.close();
	}
}
