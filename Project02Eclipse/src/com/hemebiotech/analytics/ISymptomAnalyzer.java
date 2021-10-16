package com.hemebiotech.analytics;

import java.util.Map;
import java.util.TreeMap;

/**
 * Anything that will analyze the trends. This program will describe the symptom
 * and their number of occurrences
 */

public interface ISymptomAnalyser {
	/**
	 * @return an unsorted dictionary constructed as follow : disease=occurrence
	 */
	Map<String, Integer> GetSymptomsOccurrences();

	/**
	 * @return a dictionary sorted by key constructed as follow : disease=occurrence
	 */
	TreeMap<String, Integer> SortSymptomsAlphabetically(Map<String, Integer> unsortedSymptoms);

}
