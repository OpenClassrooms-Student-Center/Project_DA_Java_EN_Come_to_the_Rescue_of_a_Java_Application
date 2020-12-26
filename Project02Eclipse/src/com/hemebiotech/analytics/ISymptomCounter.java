package com.hemebiotech.analytics;


import java.util.List;
import java.util.Map;

public interface ISymptomCounter {

	
	Map<String, Integer> countSymptoms(List<String> list) ;

	/** methode pour récuperer les symptoms
	 * @return listResult
	 */
	
}
