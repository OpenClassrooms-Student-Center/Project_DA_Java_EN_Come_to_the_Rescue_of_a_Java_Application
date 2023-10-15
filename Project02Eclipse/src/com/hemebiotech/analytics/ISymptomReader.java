package com.hemebiotech.analytics;

import java.util.List;

/**
 * Interface that allows you to read the list of symptoms from the
 * “symptoms.txt” file which is a list of strings, that may contain many
 * duplications
 * 
 */
public interface ISymptomReader {

	/**
	 * If no data is available, return an empty List
	 * 
	 * @return a raw listing of all Symptoms obtained from a data source, duplicates
	 *         are possible/probable
	 */
	public List<String> getSymptoms();
}
