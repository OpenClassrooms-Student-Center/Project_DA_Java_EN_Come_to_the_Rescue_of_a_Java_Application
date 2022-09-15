package com.hemebiotech.analytics;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author massine
 * 
 *         cette class compte toutes les occurrences de tout symptôme liste dans
 *         le fichier
 */
public class CalculOccuranceSymptomes implements ISymptomCalcul {

	@Override
	public Map<String, Integer> getMapSymptomes(List<String> listeSymptomes) {
		int nombreOccurance = 0;
		Map<String, Integer> mapSymptomes = new HashMap<>();

		for (String element : listeSymptomes) {
			if (mapSymptomes.containsKey(element)) {
				nombreOccurance = mapSymptomes.get(element);
				mapSymptomes.put(element, nombreOccurance + 1);
			} else {
				mapSymptomes.put(element, 1);
			}
		}

		return mapSymptomes;
	}
}
