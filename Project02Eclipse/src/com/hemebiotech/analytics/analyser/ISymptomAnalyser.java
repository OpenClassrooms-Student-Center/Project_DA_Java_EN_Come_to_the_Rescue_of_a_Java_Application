package com.hemebiotech.analytics.analyser;

import java.util.List;
import java.util.TreeMap;

public interface ISymptomAnalyser {

	/**
	 * 
	 * @param symptoms symptoms read from symptoms.txt
	 * @return a Treemap with symptom as key, count as value
	 */
	TreeMap<String, Integer> count( List<String> symptoms );
	
}
