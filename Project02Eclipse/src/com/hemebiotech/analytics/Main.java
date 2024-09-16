package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

public class Main {

	public static void main(String[] args) {
		
		ISymptomReader reader = new ReadSymptomDataFromFile ("C:\\Users\\emman\\git\\jurquet_emmanuel_debug_java\\Project02Eclipse\\symptoms.txt");
		ISymptomWriter writer= null;
		AnalyticsCounter counter = new AnalyticsCounter(reader, writer);
	
		List<String> symptoms = counter.getSymptoms();
		
		Map<String, Integer> countedSymptoms = counter.countSymptoms(symptoms);
		
		Map<String, Integer> sortedSymptoms = counter.sortSymptoms(countedSymptoms);
		
		counter.writeSymptoms(sortedSymptoms);
		
	}

}
