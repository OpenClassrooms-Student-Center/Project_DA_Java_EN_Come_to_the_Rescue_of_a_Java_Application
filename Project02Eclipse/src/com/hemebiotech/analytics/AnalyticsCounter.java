package com.hemebiotech.analytics;


import java.util.List;
import java.util.Map;
import java.util.TreeMap;



/*
*ICountSymptoms interface implementation 
*/

public class AnalyticsCounter implements ICountSymptoms  {


	/*
	 * Creating a symptoms list from symptom file, and get the result in alphabetical order by TreeMap function
	 */
	public Map<String, Integer> countSymptoms(List<String> listsymptoms) {
		
		Map<String, Integer> symptoms = new TreeMap<>();
		
		for (String line : listsymptoms) {
	
		
		/*
		 * Counting the occurrences of symptoms with the key (String) and the value (Integer) of our Map function
		 * param key key whose presence in this map is to be tested
		*/ 
			
			if(symptoms.containsKey(line)) {
			//* * @param value value whose presence in this map is to be tested
			//**@return {@code true} if this map maps one or more keys to the specified value
		
				int value = symptoms.get(line);
				symptoms.put(line, value+1);
				
			}
			else symptoms.put(line, 1);
			
		}
		
		return symptoms;
	}

}
			
	