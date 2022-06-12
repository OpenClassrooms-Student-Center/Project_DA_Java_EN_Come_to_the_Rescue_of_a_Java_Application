package com.hemebiotech.analytics;

import java.util.HashMap;

import java.util.Map;



public class SymptomCounter {
	
	
	
public static Map<String, Integer> countOccurences(ReadSymptomDataFromFile list){
	

	Map<String, Integer> SymptomCount = new HashMap<String, Integer>();
	
		
	for(String nameSymptom : list.GetSymptoms()) {
			
		Integer i = SymptomCount.get(nameSymptom);
		if ( i == null) {
			SymptomCount.put(nameSymptom, 1);
			
		} else {
			SymptomCount.put(nameSymptom, i + 1);
		}
	
	}
	return SymptomCount;
		
	}

}
	
		
	
	
	
