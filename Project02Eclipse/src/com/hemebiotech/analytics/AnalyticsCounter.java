
package com.hemebiotech.analytics;

import java.util.ArrayList;// Package containing the ArrayList class
import java.util.List;// Package containing the List class
import java.util.Map;// Package containing the Map class (collection)
import java.util.TreeMap;// Package containing the TreeMap class (sorted alphabetically)

/**
 * analyzes the occurrences of symptoms listed in a file to write it to a new
 * file
 * 
 * @author Dave Discamps
 *
 */

public class AnalyticsCounter {

	/*
	 * main method which processes a file parses it and writes it in alphabetical
	 * order to a new file
	 * 
	 * @see ISymptomReader
	 * 
	 * @see ReadSymptomFromFile
	 * 
	 * @see MapSympCount
	 * 
	 * @see ISymptomWriter
	 * 
	 * @see WriterSymptom
	 * 
	 * @param args - The command line parameters.
	 * 
	 * @throws Exception
	 */

	public static void main(String args[]) throws Exception { // first get input

		// folder containing symptoms
		String docFile = "symptoms.txt";

		// list of symptoms
		List<String> symptoms = new ArrayList<String>();

		// symptom map
		Map<String, Integer> mapSym = new TreeMap<String, Integer>();

		ReadSymptomDataFromFile sympFile = new ReadSymptomDataFromFile(docFile);
		symptoms = sympFile.getSymptoms();// read each line of the file and return a list

		MapSympCount mapSymptoms = new MapSympCount();
		mapSym = mapSymptoms.mapSym(symptoms);// count all occurrences of symptoms

		ISymptomWriter writerSymptom = new WriterSymptom();
		writerSymptom.writeResult(mapSym, symptoms);// write a symptom map in alphabetical order to a file

	}
}
