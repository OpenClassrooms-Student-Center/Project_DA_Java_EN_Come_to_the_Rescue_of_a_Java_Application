package com.hemebiotech.analytics;

import java.util.List; // Package of the list class
import java.util.Map; // Package of the map class
import java.util.TreeMap; // Package of the map sort class

/**
 * Takes a list of symptoms and return map of symptoms with occurrence and
 * sorted by alphabetical order
 * 
 * @Param : List of symptoms
 * @result : Map of occurrences symptoms
 * 
 * @author HousM
 *
 */

public class AnalyticsCounter {

	public Map<String, Integer> mapCountTree(List<String> ListSymptoms) {
		Map<String, Integer> mapCount = new TreeMap<String, Integer>();

		for (String m : ListSymptoms) {
			if (mapCount.containsKey(m)) {
				mapCount.put(m, (mapCount.get(m) + 1));
			} else {
				mapCount.put(m, 1);
			}
		}
		for (String key : mapCount.keySet()) {

			System.out.println(key + " = " + mapCount.get(key));
		}
		return mapCount;
	}

}
