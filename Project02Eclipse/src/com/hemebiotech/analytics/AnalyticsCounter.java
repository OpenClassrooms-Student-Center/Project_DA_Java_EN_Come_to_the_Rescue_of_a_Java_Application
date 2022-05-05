package com.hemebiotech.analytics;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AnalyticsCounter implements ISymptomCounter{
	
	private List<String> listOfSymptoms;

	public AnalyticsCounter(List<String> listOfSymptoms) {
		this.listOfSymptoms = listOfSymptoms;
	}

	@Override
	public Map<String, Integer> symptomCounter() {
		Map<String, Integer> result = new HashMap<String, Integer>();
		int counter = 0;
		for ( String symptom : listOfSymptoms) {
			for(int i=0; i < listOfSymptoms.size(); i++){
				if(symptom.equals(listOfSymptoms.get(i))) {
					counter++;
				}
			}
			if(!result.containsKey(symptom)) {
				result.put(symptom, counter);
			}
			counter = 0;
		}
		return result;
	}
	
}
