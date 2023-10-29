package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

public class Main {

	public static void main(String[] args) {
		
		ISymptomReader reader = new ReadSymptomDataFromFile(".\\Project02Eclipse\\symptoms.txt");
		ISymptomWriter writer = new WriteSymptomDataToFile(".\\Project02Eclipse\\result.out");

		AnalyticsCounter analyticsCounter = new AnalyticsCounter(reader, writer);

		List<String> symptomsList = AnalyticsCounter.getSymptoms();
		Map<String, Integer> countsBySymptoms = analyticsCounter.countSymptoms(symptomsList);
		Map<String, Integer> sortedSymptoms = analyticsCounter.sortSymptoms(countsBySymptoms);
		AnalyticsCounter.writeSymptoms(sortedSymptoms);
	}
}
