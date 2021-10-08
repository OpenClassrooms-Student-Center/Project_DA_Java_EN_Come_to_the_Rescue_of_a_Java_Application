package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class SymptomsCounter implements ISymptomCounter {

	@Override
	public Map<String, Integer> GetSymptomsOccurence(List<String> list_symptoms) {
		Map<String, Integer> symptoms_map = new TreeMap<String, Integer>();
		for (int j = 0; j < list_symptoms.size(); j++) {
			// je récupère le symptome
			String symptom = list_symptoms.get(j);
			// je fais une boucle dans la hashmap
			// je vérifie si le symptome est déjà présent
			Boolean present = symptoms_map.containsKey(symptom);

			// si présent, j'incrémente son occurence de +1
			// si pas présent je l'ajoute à la hashmap et j'initialise son occurence à 1
			if (present == false) {
				symptoms_map.put(symptom, 1);
			} else {
				int occurence = symptoms_map.get(symptom);
				occurence++;
				symptoms_map.put(symptom, occurence);
			}

		}

		return symptoms_map;
	}

}
