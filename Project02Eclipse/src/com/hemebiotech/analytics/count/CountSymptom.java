package com.hemebiotech.analytics.count;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Count and order a list of symptoms by iterating on a List to return a TreeMap 
 *
 */
public class CountSymptom implements ISymptomCounter{
	/**
	 * Count and order a list of symptoms by iterating on the List to return a TreeMap of symptoms
	 * 
	 * @param symptomsList a raw listing of all symptoms
	 * @return an ordered and counted map of all symptoms as keys and number of occurrences as values
	 */
	public Map<String, Integer> countSymptoms (List<String> resultList){
		Map<String, Integer> resultsMap = new TreeMap<String, Integer>();
		for (String symptom : resultList) {
			Integer nbSymptoms = resultsMap.get(symptom);
			resultsMap.put(symptom, (nbSymptoms == null ? 1 : nbSymptoms + 1));
		}	
		return resultsMap;
	}
}
