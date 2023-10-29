package com.hemebiotech.analytics;

import java.util.Map;

/**
 * Anything that will write in a file the symptoms and their quantities
 * contained in a map.
 */

public interface ISymptomWriter {
	/**
	 * @param a map containing the symptoms and their quantities.	 
	 */
	public void writeSymptoms(Map<String, Integer> symptoms);
}