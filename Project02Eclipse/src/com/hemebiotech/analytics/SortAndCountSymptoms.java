package com.hemebiotech.analytics;

import java.util.*;

/**
 * 
 * @author quent
 * 
 */
public class SortAndCountSymptoms {
	public List SortedUniqueSymptoms(ArrayList<String> original) {
		Set<String> mySet = new HashSet<String>(original);
		ArrayList<String> result = new ArrayList<String>(mySet);
		Collections.sort(result);
		
		return result;
		
	}
	public List CountedSymptoms(ArrayList<String> original) {
		original.forEach(i){
			
		}
		return original;
		
	}
	
	public static void Count(String)

}
