package com.hemebiotech.analytics;

import java.io.BufferedReader;

/**
 * Anything that will get symptom data from a source
 * The important part is, the return value from the operation, which is a BufferedFile
 */
public interface ISymptomReader {
	/**
	 * If no data is available, return an empty BufferedFile
	 * 
	 * @return a BufferedFile with of all Symptoms obtained from a data source
	 */
	BufferedReader GetAllSymptoms ();
}
