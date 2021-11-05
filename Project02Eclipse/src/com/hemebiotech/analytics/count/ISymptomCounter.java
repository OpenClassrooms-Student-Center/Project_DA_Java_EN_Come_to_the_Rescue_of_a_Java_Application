package com.hemebiotech.analytics.count;

import java.util.List;
import java.util.Map;

/**
 * Order and count a List of symptoms into a Map
 *
 */
public interface ISymptomCounter {
	/**
	 * Order and count a List of symptoms into a Map
	 *  
	 * @param resultList a raw listing of all symptoms
	 * @return an ordered and counted map of all symptoms as keys and number of occurrences as values
	 */
	Map<String, Integer> countSymptoms (List<String> resultList);
}
