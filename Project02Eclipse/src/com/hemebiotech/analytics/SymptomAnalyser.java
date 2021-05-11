package com.hemebiotech.analytics;

import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

public class SymptomAnalyser implements ISymptomAnalyser {

	@Override
	public TreeMap<String, Integer> count(List<String> symptoms) {
		
		TreeMap<String, Integer> result = new TreeMap<String, Integer>();
		
		
		
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
