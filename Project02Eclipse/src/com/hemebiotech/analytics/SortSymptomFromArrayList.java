package com.hemebiotech.analytics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeMap;

/**
 * @author alex
 * @version 1.0 convert an unordered ArrayList with duplications into TreeMap :
 *          keys : (ordered) list of symptoms, values : occurrences number of
 *          each symptom
 */
public class SortSymptomFromArrayList {

	private ArrayList<String> symptomList = new ArrayList<String>();

	/**
	 * @param ArrayList of symptoms
	 */
	public SortSymptomFromArrayList(ArrayList<String> symptomList) {
		this.symptomList = symptomList;
	}

	/**
	 * (1) copy the first occurrence of a symptom from an ArrayList (2) add the
	 * symptom in a TreeMap with its number of occurrences in a TreeMap
	 * 
	 * @return TreeMap
	 */
	public TreeMap<String, Integer> sortSymptom() {
		TreeMap<String, Integer> symptomAndOccurrencesMap = new TreeMap<String, Integer>();

		if (symptomList != null) {
			for (String elt : symptomList) {
				if (!symptomAndOccurrencesMap.containsKey(elt)) {
					symptomAndOccurrencesMap.put(elt, Collections.frequency(symptomList, elt));
				}
			}
		}
		return symptomAndOccurrencesMap;
	}
}
