package com.hemebiotech.analytics;

import java.util.Map;

/**
 * 
 * @author Rayane Berrada
 *
 * Create a new file using information
 */
public interface ISymptomWriter {
	/**
	 * Create a new file containing the informations organized by the implementation
	 * of the Analytics Interface
	 * 
	 */
	public void createFile(Map<String, Integer> symptoms);
}
