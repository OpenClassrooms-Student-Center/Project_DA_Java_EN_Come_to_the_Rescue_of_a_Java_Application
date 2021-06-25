package com.hemebiotech.analytics;

import java.util.List; // import of the LIST utility class to use
import java.util.Map; // import of the Map utility class to use
import java.util.TreeMap; // import of the mapTree utility class to use

/**
 * Takes a list of symptoms and return map of symptoms with occurrence and
 * sorted by alphabetical order
 * 
 * @Param : List of symptoms
 * @result : Map of occurrences symptoms sorted
 * 
 * @author HousM
 *
 */

public class AnalyticsCounter {

	public Map<String, Integer> mapCountTree(List<String> ListSymptoms) {
		Map<String, Integer> mapCount = new TreeMap<String, Integer>();

		for (String Symptom : ListSymptoms) {
			if (mapCount.containsKey(Symptom)) {
				mapCount.put(Symptom, (mapCount.get(Symptom) + 1));
			} else {
				mapCount.put(Symptom, 1);
			}
		}
		for (String key : mapCount.keySet()) {

			System.out.println(key + " = " + mapCount.get(key));
		}
		return mapCount;
	}

}
