package com.hemebiotech.analytics;


import java.util.TreeMap;

public interface IAnalyticsCounter {
	
	/**
	 * Anything that will calculate number of occurrences of symptom 
	 * The important part is, the return value from the operation, which is a TreeMap<String,Long> that contain symptoms and their occurrences
	 * @return sorted TreeMap <String, Long> 
	 */
	TreeMap<String, Long> getSymptomsOccurences();
}
