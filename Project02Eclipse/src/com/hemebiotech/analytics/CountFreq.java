package com.hemebiotech.analytics;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountFreq {
	
	public Map<String, Integer> CountFrequency(List<String> list){
        Map<String, Integer> hashMapFrequency = new HashMap<String, Integer>(); 
        
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
