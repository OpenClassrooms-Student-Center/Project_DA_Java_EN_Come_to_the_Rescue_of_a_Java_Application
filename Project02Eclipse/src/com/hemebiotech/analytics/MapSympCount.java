package com.hemebiotech.analytics;

import java.util.List;// Package containing the List class
import java.util.Map;// Package containing the Map class (collection)
import java.util.TreeMap;// Package containing the TreeMap class (sorted alphabetically)

/**
 * take a list of symptoms and count the occurrences
 * 
 * @author Dave Discamps
 *
 */

public class MapSympCount {

	/**
	 * counts the occurrences of the different symptoms in the list
	 * 
	 * @param symptoms list of symptoms
	 * @return a map of the symptoms in alphabetical order as well as their
	 *         occurrences
	 */
	public Map<String, Integer> mapSym(List<String> symptoms) {
		Map<String, Integer> mapSym = new TreeMap<String, Integer>();
		if (symptoms != null) {
			for (String s : symptoms) {

				mapSym.put(s, mapSym.containsKey(s) ?

						mapSym.get(s) + 1 : 1);

			}

			for (String key : mapSym.keySet()) {

				System.out.println(key + "=" + mapSym.get(key));

			}

		}

		return mapSym;
	}
}
