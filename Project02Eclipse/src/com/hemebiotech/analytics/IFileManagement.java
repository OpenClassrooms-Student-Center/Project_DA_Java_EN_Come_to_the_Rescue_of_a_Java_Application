package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

/**
 * Anything that will read symptom data from a source
 * The important part is, the return value from the operation, which is a list of strings,
 * that may contain many duplications
 * 
 * The implementation does not need to order the list
 * 
 */
public interface IFileManagement {
	/**
	 * If no data is available, return an empty List
	 * 
	 * @return a raw listing of all Symptoms obtained from a data source, duplicates are possible/probable
	 */
	public List<String> getSymptoms();

	/**
	 * Method that count the number of time each symptoms is written then sort those symptoms by alphabetic order
	 * @param symptomsList
	 * @return a Map that contain a String as the key and a Long as the value
	 */
	public Map<String, Long> countAndSortSymptoms(List<String> symptomsList);

	/**
	 * Method that generate a file were all the symptoms are written
	 * @param occurenceBySymptoms
	 */
	public void generateSymptomsReport(Map<String, Long> occurenceBySymptoms);
}
