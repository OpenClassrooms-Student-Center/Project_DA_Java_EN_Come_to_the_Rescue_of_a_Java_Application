package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

/**
 * Anything that will count the number of symptoms appearances in a text file
 * The important part is, the return value from the operation, which is a number
 * of symptom occurrences,
 *
 * 
 */
public interface IOccurrencesCount {
	/**
	 * 
	 * @param symptomsList a list of symptoms imported from symptoms.txt file
	 * 
	 * @return occurrence a number of symptoms appearances in the symptoms.txt file
	 */
	public Map<String, Integer> getNumberOccurrences(List<String> symptomsList);

}
