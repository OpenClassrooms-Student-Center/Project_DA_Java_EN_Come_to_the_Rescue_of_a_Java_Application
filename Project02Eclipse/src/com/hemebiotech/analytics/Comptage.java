package com.hemebiotech.analytics;

import java.util.List;
import java.util.TreeMap;

/*
 * Comptage du nombre de symptoms identiques.
 */
public class Comptage implements Icomptage {

	@Override
	public TreeMap<String, Integer> comptageSymptomsData(List<String> symptoms) {
		TreeMap<String, Integer> symptomsTri = new TreeMap<>();
		for (String listSymptoms : symptoms) {
			if (symptomsTri.containsKey(listSymptoms)) {
				symptomsTri.put(listSymptoms, symptomsTri.get(listSymptoms) + 1);
			} else {
				symptomsTri.put(listSymptoms, 1);
			}

		}
		return symptomsTri;
	}

}
