package com.hemebiotech.analytics;

import java.util.Map;

/**
 * Anything that will read symptom data from a source
 * The important part is, the return value from the operation, which is a list of strings,
 * that may contain many duplications
 * @author MrgnCpn
 */
public interface ISymptomReader {	
	/**
	 * Read symptoms from file and return a empty list if no data is available
	 * @return HashMap with symptoms name in keys and count of then in value (Map<"SymptomsName", Count>)
	 */
	Map<String, Integer> GetSymptoms();
	
	/**
	 * Order by keys a Map
	 * @param symptomsList, non sorted map
	 * @return TreeMap order by keys (A...Z or 1...10)
	 */
	Map<String, Integer> sortSymptomsByKey(Map<String, Integer> symptomsList);
	
	/**
	 * Order by values a Map
	 * @param symptomsList, non sorted map
	 * @return Map order by values (A...Z or 1...10)
	 */
	Map<String, Integer> sortSymptomsByValue(Map<String, Integer> symptomsList);
}
