package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Classe implémentant l'interface ISymptomCounter permettant de compter le
 * nombre d'occurence d'un symptome à partir d'une liste
 * 
 * @author Fouad
 * 
 * @return un tableau contenant la liste des symptomes avec leurs occurences
 *         respectives
 * 
 */
public class SymptomsCounter implements ISymptomCounter {
	/**
	 * {@inheritDoc}
	 */
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
