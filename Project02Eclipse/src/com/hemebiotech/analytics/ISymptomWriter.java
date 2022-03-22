package com.hemebiotech.analytics;

/**
 *@author Fatima
 *
 */
public interface ISymptomWriter {
	
	/**
	 * 
	 * Method that generate output file : 
	 * create a new file in the file path
	 * fill the file with symptoms and their occurrences
	 */
	void generateOutputFile();
}
