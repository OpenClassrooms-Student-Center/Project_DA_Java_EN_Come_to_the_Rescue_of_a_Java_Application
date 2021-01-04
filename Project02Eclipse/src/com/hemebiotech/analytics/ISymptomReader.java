package com.hemebiotech.analytics;

import java.util.ArrayList;
import java.util.Map;

/**
 * Interface ISymptomWriter: Anything that will read symptom data from a source
 * and produce a list or dictionary. According to the method called,
 * duplications are possible or not.
 */
public interface ISymptomReader {

	/**
	 * If no data is available, return an empty List
	 * 
	 * @return a raw listing of all Symptoms obtained from a data source, duplicates
	 *         are possible/probable
	 *    
	 * @param filepath
	 *    
	 */
public ArrayList<String> getSymptomsWithDuplicate(String filepath);

	/**
	 * If no data is available, return an empty Map
	 * 
	 * @return a dictionary of all the symptoms obtained from a data source in the
	 *         <b> format: { key (symptom): value (occurrence) } </b>. Duplicates
	 *         are not possible/probable
	 *         
	 * @param listSymptomWithDuplicat
	 */
public Map<String, Integer> getSymptomsRate(ArrayList<String> listSymptomWithDuplicat);

}
