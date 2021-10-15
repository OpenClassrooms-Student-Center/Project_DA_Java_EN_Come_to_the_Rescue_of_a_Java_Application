package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class SymptomsCounter implements ISymptomCounter {

	@Override
	public Map<String, Integer> getSymptomsOccurence(List<String> listSymptoms) {
		Map<String, Integer> symptomsMap = new TreeMap<String, Integer>();
		for (int j = 0; j < listSymptoms.size(); j++) {

			String symptom = listSymptoms.get(j);
			Boolean present = symptomsMap.containsKey(symptom);

			if (!present) {
				symptomsMap.put(symptom, 1);
			} else {
				int occurence = symptomsMap.get(symptom);
				occurence++;
				symptomsMap.put(symptom, occurence);
			}

		}

		return symptomsMap;
	}

}
