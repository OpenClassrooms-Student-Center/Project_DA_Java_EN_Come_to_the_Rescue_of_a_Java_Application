package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

public class AnalyticsCounter {	
	
	public List<String> read (String filepath) {
		ISymptomReader reader = new ReadSymptomDataFromFile(filepath);
		List<String> symptoms = reader.getSymptoms();
		return symptoms;
	}
	
	public Map<String, Integer> sortAndCount (List<String> symptoms) {
		ISymptomSorter sorter = new SortSymptomDataFromList(symptoms);
		Map<String, Integer> sorted = sorter.sortSymptoms();
		return sorted;
	}
	
	
	public void write (Map<String, Integer> sorted, String filepath) {
		
		ISymptomWriter Writer = new WriteSymptomDataFromMap(sorted);
		Writer.WriteSymptoms();
	}

	
}
