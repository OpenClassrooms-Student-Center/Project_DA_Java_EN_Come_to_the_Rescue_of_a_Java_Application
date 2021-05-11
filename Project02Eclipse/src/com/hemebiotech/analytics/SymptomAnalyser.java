package com.hemebiotech.analytics;

import java.util.HashMap;
import java.util.List;

public class SymptomAnalyser implements ISymptomAnalyser {

	@Override
	public HashMap<String, Integer> count(List<String> symptoms) {
		
		HashMap<String, Integer> result = new HashMap<String, Integer>();
		
		for (String symptom : symptoms) {
			
			// Force value to be 0 if not existing already
			result.putIfAbsent(symptom, 0);
			
			//Get the value 
			int currentValue = result.get(symptom);
			
			//increment it
			result.put(symptom, ++ currentValue);
			
			
		}
		
		return result;
	}

	
	
}
