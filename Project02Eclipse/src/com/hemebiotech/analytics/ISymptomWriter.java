package com.hemebiotech.analytics;

/**
 * Anything that will write symptom data from a source
 * The important part is, the result from the operation, which is a document who show all symptoms with their ocurrences,
 * 
 * 
 */
public interface ISymptomWriter {
	/**
	 * If no data is available, return an empty document
	 * 
	 * @return a raw listing of all Symptoms obtained from a data source, duplicates are possible/probable
	 */
	void WriteSymptoms ();
}