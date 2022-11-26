package com.hemebiotech.analytics;


import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class AnalyticsCounter {
	

	/**
     * Read alphabeticSymptomList and create a Map with name and number
     * @param alphabeticSymptomList
     * @return Map of symptom and number
     */
	
    public Map<String, Integer> groupSymptoms(List<String> alphabeticSymptomList) {
    	Map<String, Integer> map = new HashMap<>();
        for (String symptom : alphabeticSymptomList) {
            Integer nombre = map.get(symptom);
            if (nombre == null) {
                nombre = 0;
            }
            nombre++;
            map.put(symptom, nombre);
        }
        return map;
    }        

    /**
     * Sort the map of grouped symptoms     
     * @param groupedSymptoms
     * @return list of symptoms sorted in alphabetical order
     */
   
    public Map<String, Integer> sortOfSymptoms(Map<String, Integer> groupedSymptoms) {        
        
    	Map<String, Integer> result = new LinkedHashMap<>();
        groupedSymptoms.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .forEachOrdered(x -> result.put(x.getKey(), x.getValue()));     
        return result;
        
    }
} 
	