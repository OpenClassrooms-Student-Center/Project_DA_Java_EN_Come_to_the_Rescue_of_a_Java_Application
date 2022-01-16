package com.hemebiotech.analytics;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * SymptomsDataProcessing allows processing of symptom data
 * 
 * @see ISymptomsDataProcessing
 */

public class SymptomsDataProcessing implements ISymptomsDataProcessing {

	@Override
	public Map<String, Integer> sortedSymptoms(Map<String, Integer> symptomMap, Comparator<String> comparator) {

		Map<String, Integer> sorted_map = new TreeMap<String, Integer>(comparator);
		sorted_map.putAll(symptomMap);
		return sorted_map;

	}

	@Override

	public Map<String, Integer> symptomsCounter(List<String> symptomList) {

		Map<String, Integer> symptomMap = new HashMap<>();

		for (String symptom : symptomList) {

			if ((!symptomMap.containsKey(symptom)) && ((symptom != null))) {

				symptomMap.put(symptom, 1);

			} else {

				symptomMap.put(symptom, symptomMap.get(symptom) + 1);

			}

		}

		return symptomMap;
	}

}
