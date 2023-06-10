package com.hemebiotech.analytics;

import java.util.HashMap;
import java.util.Map;

/**
 * ISymptomWriter is an interface which is contains one method writeSymptoms.
 * This method write the result of the hash in a file
 * 
 * 
 */
public interface ISymptomWriter {
	Map<String, Integer> symptoms = new HashMap<>();

	/**
	 * This method create a file filepathOut and write the symptoms and its
	 * occurrence from a raw called symptoms contains symptoms (key) and occurrence
	 * (value)
	 * 
	 * @param symptoms raw with symptoms (key) and occurrence (value)
	 */
	public void writeSymptoms(Map<String, Integer> symptoms);

}