package com.hemebiotech.analytics;

import java.util.List;
import java.util.TreeMap;

/**
 * Calls the ReadSymptomDataFromFile class and its methods. Reading the source
 * file and integrates the alphabetical sorting function with TreeMap.
 * 
 * @author didier
 *
 */
public class ExtracSymptomData {

	public TreeMap<String, Integer> extracSymptomsData() {

		ReadSymptomDataFromFile file = new ReadSymptomDataFromFile("Project02Eclipse/symptoms.txt");
		file.getSymptoms();
		List<String> symptomsFile = file.getSymptoms();

		TreeMap<String, Integer> symptomsTri = new TreeMap<>();
		for (String listSymptoms : symptomsFile) {
			if (symptomsTri.containsKey(listSymptoms)) {
				symptomsTri.put(listSymptoms, symptomsTri.get(listSymptoms) + 1);
			} else {
				symptomsTri.put(listSymptoms, 1);
			}

		}
		return symptomsTri;
	}

}
