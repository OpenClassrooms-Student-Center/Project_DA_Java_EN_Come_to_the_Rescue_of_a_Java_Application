package com.hemebiotech.analytics;

import java.util.HashMap;
import java.util.List;

public interface ISymptomAnalyser {

	/**
	 * 
	 * @param symptoms symptoms read from symptoms.txt
	 * @return a hashmap with symptom as key, count as value
	 */
	HashMap<String, Integer> count( List<String> symptoms );
	
}
