package com.hemebiotech.analytics;

import java.io.IOException;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Analyzes tendencies of occurrences of symptoms listed in a file.
 * 
 * @author Yassine PAYET
 *
 */
public class AnalyticsCounter {

	/**
	 * File containing the reported symptoms.
	 */
	static String docFile = new String("symptest.txt");
	/**
	 * List of symptoms
	 */
	static List<String> symptoms = new ArrayList<String>();
	/**
	 * Map of symptoms
	 */
	static Map<String, Integer> sympMap = new TreeMap<>();

	/**
	 * This is the main method which processes a file, analyzes it and writes the
	 * results in a new file.
	 * 
	 * 
	 * @see ReadSymptomFromFile
	 * @see MapSymptomCount
	 * @see WriteResultFromMap
	 * @param args - The command line parameters.
	 * @throws IOException
	 */

	public static void main(String[] args) throws IOException, NullPointerException, ConcurrentModificationException {

		ReadSymptomFromFile docPath = new ReadSymptomFromFile(docFile); // get absolute path of a file

		symptoms = docPath.GetSymptom(); // read each lines of a file and return a list

		sympMap = MapSymptomCount.mapSymptom(symptoms); // count all occurrences

		WriteResultFromMap.writeResult(sympMap, symptoms); // writes in a file a map of symptoms in natural order
	}

}
