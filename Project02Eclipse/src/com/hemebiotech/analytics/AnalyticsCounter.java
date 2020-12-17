package com.hemebiotech.analytics;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class AnalyticsCounter {
	public static void main(String[] args) throws IOException {

		// Read symptoms from file: symptoms.txt
		ReadSymptomDataFromFile fileReader = new ReadSymptomDataFromFile("symptoms.txt");
		List<String> listOfSymptoms = fileReader.GetSymptoms();

		// Alphabetize symptoms and count occurrences
		CountSymptoms counter = new CountSymptoms();
		Map<String, Integer> mapSymptoms = counter.getSymptoms(listOfSymptoms);

		// Write results to file: result.txt
		SymptomsWriter fileWriter = new SymptomsWriter();
		fileWriter.toFile("result.txt", mapSymptoms);
	}
}
