package com.hemebiotech.analytics;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Count the occurrence from an ArrayList and return a HashMap
 *
 */
public class AnalyticsCounter {
	/**
	 * @param map : Object type Map<String, Integer>
	 * @param list : Object type List
	 * @return map : Object type HashMap<String, Integer>
	 */

	public Map<String, Integer> count (List<String> list) {

		Map<String, Integer> map = new HashMap<String, Integer>();
		for (String symptom : list) {
			Integer value = map.get(symptom);
			if ( value == null) {
				map.put(symptom, 1);

			} else {
				map.put(symptom, value+1);
			}
		}
		return map;
	}
}