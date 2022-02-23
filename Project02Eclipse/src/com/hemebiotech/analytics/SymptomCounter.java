package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
/**
 * @author DOLLOU
 * @since 09/02/2022
 */

public class SymptomCounter {
/**
* @param a String List 
* @return a map with symptoms and instances without duplicate
* 	
*/

	public Map<String, Integer> listToMap(List<String> symptoms) {
		
	

		Map<String, Integer> map = new TreeMap<>();

		for (String symptom : symptoms) {

			if (map.keySet().contains(symptom)) {

				map.put(symptom, map.get(symptom) + 1);
			} else {

				map.put(symptom, 1);
			}
		}
		return map;

	}

}
