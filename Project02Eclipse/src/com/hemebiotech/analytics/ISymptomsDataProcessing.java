
package com.hemebiotech.analytics;

import java.util.Comparator;
import java.util.List;
import java.util.Map;

/**
 * 
 * ISymptomsDataProcessing the processing of symptoms data
 * 
 * @see ISymptomReaderd
 * 
 */

public interface ISymptomsDataProcessing {

	/**
	 * count the number of occurrences
	 * 
	 * @param symptomsList list of Symptoms.
	 * @return Map with symptom in the key field and its frequency in the value
	 *         field.
	 */
	public Map<String, Integer> symptomsCounter(List<String> symptomsList);

	/**
	 * 
	 * sort the symptoms
	 * 
	 * @param symptomMap Map with symptom in the key field and its frequency in the
	 *                   value field.
	 * @param comparator comparator used to order the keys in this map, if is null
	 *                   this map uses the alphabetical order.
	 * @return Sorted Map with symptom in the key field and its frequency in the
	 *         value field.
	 */

	public Map<String, Integer> sortedSymptoms(Map<String, Integer> symptomMap, Comparator<String> comparator);

}
