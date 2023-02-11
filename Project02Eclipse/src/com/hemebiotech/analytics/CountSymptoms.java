/**
 * 
 */
package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.hemebiotech.analytics.interfaces.ICountSymptoms;


public class CountSymptoms implements ICountSymptoms {
	/**
	 * Load symptoms from a List structure to a Map Structure 
	 * @param  List Symptoms
	 * @return Sort Map Symptoms
	 * @author Laurent
	 * @Version 1.0
	 *
	 */
	 
	@Override
	public Map<String, Integer> countSymptomsLstToHash(List<String> lstSymptoms){
		Map<String, Integer> hashSymptoms = new TreeMap<>();
		String strSymptoms = "";
		int iNbOccurrence = 0;
		
		for(int i=0; i < lstSymptoms.size(); i++) {
			strSymptoms = lstSymptoms.get(i);
			iNbOccurrence = hashSymptoms.getOrDefault(strSymptoms, 0).intValue() + 1;
			hashSymptoms.put(strSymptoms, iNbOccurrence);
		} 
		return hashSymptoms;
	}
}
