package com.hemebiotech.analytics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountFreq {
	
	public List<String> CountFrequency(List<String> list){
		
		List<String> resultCount = new ArrayList<String>(); 
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

        for (Map.Entry<String, Integer> value : hashMapFrequency.entrySet()) { 
        	resultCount.add(value.getKey() + " x " +  value.getValue() + "\n");
        }
        return resultCount;
	}
}
