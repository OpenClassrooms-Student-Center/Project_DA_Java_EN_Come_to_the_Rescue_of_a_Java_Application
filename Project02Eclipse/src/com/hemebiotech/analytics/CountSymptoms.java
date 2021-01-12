package com.hemebiotech.analytics;

import java.util.List;
import java.util.*;

/**
 * Anything that will read symptom data from a source The important part is, the
 * return value from the operation, which is a list of strings, that may contain
 * many duplications. The implementation order the list.
 * 
 */
public class CountSymptoms {
	Map<String, Integer> counterSymptomsABC = new TreeMap<>();
	
	
	TreeMap<String,Double> myMap = new TreeMap<String, Double>();
	
	public Map<String, Integer> getCounterSymptomsABC(List<String> nameOfSymptoms){
		
		for(String string : nameOfSymptoms) {
			if(counterSymptomsABC.containsKey(string)) {
				counterSymptomsABC.put(string, counterSymptomsABC.get(string) + 1);
			}else {
				counterSymptomsABC.put(string, 1);
			}
		}
		for(Map.Entry<String, Integer> entry : counterSymptomsABC.entrySet()) {
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}
		return counterSymptomsABC;
	}

}
