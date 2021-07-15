package com.hemebiotech.analytics;

import java.io.IOException;
import java.util.Map;

/**
 * Anything that will write symptom in a text file The important part is, the
 * return value from the operation, which is a list of strings, that contains
 * the symptoms.
 * 
 */
public interface ISymptomWriter {
	/**
	 * If no data is available, return an empty List
	 * 
	 * @return UnOrdered List of Symptoms imported from file symptoms.txt
	 * @throws IOException 
	 */
	public void setSymptoms(Map<String, Integer> symOccurrences) throws IOException;

}
