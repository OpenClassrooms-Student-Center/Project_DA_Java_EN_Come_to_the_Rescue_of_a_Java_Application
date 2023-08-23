package com.hemebiotech.analytics;

/**
 * Reads the content of a file with a list of symptoms and then counts the
 * number of occurrences
 * for each symptom and exports the list in alphabetical order to an output file
 *
 * @author Alberto Ruiz
 */
public interface ISymptomReader {

	/**
	 * Read the contents from a text file
	 */
	void readSymptoms();

	/**
	 * Counts the number of occurrences each symptom shows up in a file
	 */
	void countSymptoms();

	/**
	 * print list of Symptoms and number of occurrences to Console
	 */
	void printToScreenSymptoms();

	/**
	 * save list of Symptoms and number of occurrences to a file
	 */
	void saveToFileSymptoms();
}