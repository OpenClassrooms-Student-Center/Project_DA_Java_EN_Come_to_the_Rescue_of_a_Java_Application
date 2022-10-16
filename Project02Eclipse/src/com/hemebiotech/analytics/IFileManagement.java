package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

/**
 * This interface allow to get the symptoms from a file, sort them and generate a report
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
	 * Method that counts the number of time each symptoms is written then sort those symptoms by alphabetic order
	 * @param symptomsList
	 * @return a Map that contain the symptom as a key and its occurence as the value
	 */
	public Map<String, Long> countAndSortSymptoms(List<String> symptomsList);

	/**
	 * Method that generates a report were all the symptoms ans their occurence are written
	 * @param occurenceBySymptoms
	 */
	public void generateSymptomsReport(Map<String, Long> occurenceBySymptoms);
}
