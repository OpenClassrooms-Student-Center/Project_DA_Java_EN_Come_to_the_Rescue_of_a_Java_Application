package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class CountFrequency {
	
	public Map<String, Integer> CountFrequency(List<String> list){
        Map<String, Integer> hashMapFrequency = new TreeMap<String, Integer>(); 
        
        for (String i : list) {  	
            Integer occurency = hashMapFrequency.get(i);
            if (occurency == null) {
            	occurency = 1;
            } else {
            	occurency += 1;
            }
            hashMapFrequency.put(i, occurency);
        }  
        return hashMapFrequency;
	}
}
