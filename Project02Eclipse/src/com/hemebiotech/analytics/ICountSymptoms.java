package com.hemebiotech.analytics;



import java.util.List;
import java.util.Map;


public interface ICountSymptoms {
	
	/*
	 * Counting all symptoms from the file "symptoms.txt", and get them in alphabetical order
	 * We're calling the countSymptoms method
	 */
	
	

	Map<String, Integer> countSymptoms(List<String> listsymptoms);



	

	
	
}
