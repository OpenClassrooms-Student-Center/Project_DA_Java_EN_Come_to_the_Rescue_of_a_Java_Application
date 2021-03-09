package com.hemebiotech.analytics;

/**
 * Anything that will read symptom data from a source The important part is, the
 * return value from the operation, which is a list of strings, that may contain
 * many duplications
 * 
 * The implementation does not need to order the list
 * 
 */
public interface IResultWriter {
	/**
	 * Write into Result.out file a list of all found results
	 * 
	 */
	void SetResults();
}
