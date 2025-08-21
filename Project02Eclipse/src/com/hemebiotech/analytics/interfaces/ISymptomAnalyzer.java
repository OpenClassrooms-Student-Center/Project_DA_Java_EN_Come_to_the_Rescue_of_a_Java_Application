package com.hemebiotech.analytics.interfaces;

import java.util.List;
import java.util.Map; 

/**
 * Interface pour analiser une liste de symptomes 
 */

public interface ISymptomAnalyzer {

	
	/** 
	 * @param liste contenant des noms de  symptomes
	 * @return un Map associant des symptomes et leur occurence
	 */
	
	Map<String, Integer> countSymptoms(List<String> symptoms);
}
