package com.hemebiotech.analytics;

import java.util.TreeMap;

/**
 * Read the data from the source file in the form of a character string, which
 * can contain occurrences. Restores a file in the form of a hierarchical list
 * of strings (key, value) counting the occurrences.
 * 
 * Using two methods
 * 
 * The implementation does not need to order the list
 */
public interface ISymptomReader {
	/**
	 * If no data is available, return an empty List
	 * 
	 * @return a raw listing of all Symptoms obtained from a data source. Duplicates
	 *         are possible/probable
	 */
	TreeMap<String, Integer> getSymptomsOccurences();

	/**
	 * Processes the list of the getSymptomsOccurences method
	 * 
	 * @return the list of symptoms in alphabetical order and displays their
	 *         quantities. Saves the processing to an output file.
	 * 
	 */

	void setMapToFile(TreeMap<String, Integer> symptomOccurence, String resultFilePath);
}