package com.hemebiotech.analytics;



import java.util.List;
import java.util.Map;


public interface ICountSymptoms {
	
	/*
	 * Count Symptoms from the given list in order to provide a filled Map with symptoms
	 * in alphabetical order
	 * 
	 * @param listsymptoms List of the symptoms to cound and order
	 * @return Map of sorted and counted symptoms
	 */
	
	Map<String, Integer> countSymptoms(List<String> listsymptoms);

}
