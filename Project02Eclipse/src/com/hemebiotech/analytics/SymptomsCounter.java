package com.hemebiotech.analytics;

import java.util.HashMap;
import java.util.List;

public class SymptomsCounter implements ISymptomCounter {

	@Override
	public HashMap<String, Integer> GetSymptomsOccurence(List<String> list_symptoms) {
		HashMap<String, Integer> symptoms_map = new HashMap<>();
		for(int j=0; j<list_symptoms.size(); j++) {
		symptoms_map.put(list_symptoms.get(j), 5);	// 3?
			
		}
		return symptoms_map;
	}

}
