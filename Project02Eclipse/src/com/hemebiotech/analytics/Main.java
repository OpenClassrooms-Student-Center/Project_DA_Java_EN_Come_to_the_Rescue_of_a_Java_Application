package com.hemebiotech.analytics;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Main {

	public static void main(String[] args) throws IOException {
		ISymptomReader reader = new ReadSymptomDataFromFile("symptoms.txt");
		ISymptomWriter writer = new WriteSymptomDataToFile("result.out");
		AnalyticsCounter analysis = new AnalyticsCounter(reader, writer);

		List<String> symptomsList = analysis.getSymptoms();
		Map<String, Integer> symptomsCount = analysis.countSymptoms(symptomsList);
		Map<String, Integer> symptomsSorted = analysis.sortSymptoms(symptomsCount);
		writer.writeSymptoms(symptomsSorted);
	}
}
