package com.hemebiotech.analytics.write;

import java.util.Map;

/**
 * write symptom data to a destination 
 * the list of symptoms is ordered and counted
 */
public interface ISymptomWriter {
	/**
	 * put out an ordered and counted list of symptoms 
	 * 
	 * @param an ordered and counted map of all symptoms as keys and number of occurrences as values
	 */
	void putSymptoms(Map<String, Integer> resultsMap);
}
