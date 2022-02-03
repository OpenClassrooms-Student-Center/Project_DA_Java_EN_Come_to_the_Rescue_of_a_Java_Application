package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * 
 * @author S076562
 * @version 1.0
 * 
 * @param filepath to a file of symptoms
 * @return a map of sorted symptoms from the input file with the number of
 *         occurs of each
 *
 */

public class SortSymptoms {

	public Map<String, Integer> sortAndCountSymptoms(String filepath) {

		Map<String, Integer> result = new TreeMap<String, Integer>();
		List<String> listSymptomsIn;

		ReadSymptomDataFromFile fichierLu = new ReadSymptomDataFromFile(filepath);
		listSymptomsIn = fichierLu.GetSymptoms();

		for (String symptom : listSymptomsIn) {
			if (result.containsKey(symptom)) {
				result.put(symptom, result.get(symptom) + 1);
			} else {
				result.put(symptom, 1);
			}
		}
		return result;
	}

}