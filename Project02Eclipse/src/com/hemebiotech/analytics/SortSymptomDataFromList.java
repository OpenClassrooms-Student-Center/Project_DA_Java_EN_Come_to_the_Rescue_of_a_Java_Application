package com.hemebiotech.analytics;

import java.util.TreeMap;
import java.util.List;
import java.util.Map;

/**
 * Simple brute force implementation
 *
 */
public class SortSymptomDataFromList implements ISymptomSorter {

	private List<String> symptoms;

	/**
	 * 
	 * @param filepath a full or partial path to file with symptom strings in it,
	 *                 one per line
	 */
	public SortSymptomDataFromList(List<String> symptoms) {
		this.symptoms = symptoms;
	}

	@Override
	public Map<String,Integer> sortSymptoms() {
		Map<String,Integer> result = new TreeMap<>();
		
		if (symptoms != null) {
			try {
                for(String symptom : symptoms){ 
                    if (result.containsKey(symptom)){
                        int v = result.get(symptom);
                        result.put(symptom, v+1);  //result.replace(symptom, v+1);
                    }
                    else{
                        result.put(symptom, 1);
                    }

        
                }
			} catch(ClassCastException|NullPointerException | IllegalArgumentException |UnsupportedOperationException e) {
				e.printStackTrace();
				}
			
		}
		
		return result;
	}

}

