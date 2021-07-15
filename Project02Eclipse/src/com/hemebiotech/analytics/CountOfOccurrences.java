package com.hemebiotech.analytics;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountOfOccurrences implements IOccurrencesCount {

	/**
	 * 
	 * @param symptomsList a list of symptoms string, that may contain many
	 *                     duplications
	 * @return Map of symptoms string as keys and occurrences number as values
	 * 
	 */
	public Map<String, Integer> getNumberOccurrences(List<String> symptomsList) {

		Map<String, Integer> sympOccurrences = new HashMap<String, Integer>();
		for (int i = 0; i < symptomsList.size(); i++) {

			if (sympOccurrences.containsKey(symptomsList.get(i))) {
				sympOccurrences.replace(symptomsList.get(i), sympOccurrences.get(symptomsList.get(i)) + 1);

			} else {
				sympOccurrences.put(symptomsList.get(i), 1);
			}

		}
		return sympOccurrences;
	}

}
