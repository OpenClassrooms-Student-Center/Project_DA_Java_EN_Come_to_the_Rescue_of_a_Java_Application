package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

//@author Amyn Fekkoul

public class Iteration {
	/*
	 * Reads the list, counts occurences, and matches them in an alphabetically
	 * order
	 *
	 * @param list Arraylist that contains each line of the file
	 *
	 * @param map Map that contains each symptom matched with its occurences The
	 * treemap orders symptoms alphabetically
	 *
	 * @return an ordered map containing symptoms and occurences
	 */

	public static void count(List<String> list, Map<String, Integer> map) {

		for (String symptom : list) {

			Integer occurence = map.get(symptom);

			if (occurence == null) {
				map.put(symptom, 1);
			} else {
				map.put(symptom, occurence + 1);
			}
		}
		System.out.println(map);
	}

}
