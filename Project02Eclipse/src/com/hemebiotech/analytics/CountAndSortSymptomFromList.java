package com.hemebiotech.analytics;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Simple brute force implementation
 *
 */

public class CountAndSortSymptomFromList implements ISymptomAnalyzer {

	private List<String> symptomList;

	/**
	 * 
	 * @param symptomList a list with symptom strings in it
	 */

	public CountAndSortSymptomFromList(List<String> symptomList) {
		this.symptomList = symptomList;
	}

	@Override
	public Map<String, Integer> GetSymptomsOccurrences() {
		Map<String, Integer> result = new HashMap<String, Integer>();
		for (String symptom : symptomList) {
			if (!result.containsKey(symptom)) {
				result.put(symptom, 1);
			} else {
				result.replace(symptom, result.get(symptom) + 1);
			}
		}
		return result;
	}

	@Override
	public TreeMap<String, Integer> SortSymptomsAlphabetically(Map<String, Integer> unsortedSymptoms) {
		TreeMap<String, Integer> sortedSymptoms = new TreeMap<>(unsortedSymptoms);
		return sortedSymptoms;
	}

}
