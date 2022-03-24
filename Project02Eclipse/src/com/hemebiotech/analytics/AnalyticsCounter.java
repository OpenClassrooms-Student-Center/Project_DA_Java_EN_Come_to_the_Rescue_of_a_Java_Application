package com.hemebiotech.analytics;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

/**
 * Main class designed for inputting file path and for successively launching
 * reading, sorting and writing classes and checking result in console
 * 
 * @author CHRISTINE TETI
 *
 */

public class AnalyticsCounter {

	public static void main(String[] args) throws Exception {
		try {

			// Call reading class and pass filepath as argument
			ISymptomReader fileReaderClass = new ReadSymptomDataFromFile("Project02Eclipse/symptoms.txt");
			ArrayList<String> result = (ArrayList<String>) fileReaderClass.GetSymptoms();

			// Call sorting class with return of reading class as argument
			SortSymptomsData sortingClass = new SortSymptomsData();
			TreeMap<String, Integer> symptoms = sortingClass.sortingSymptomsData(result);

			// Call writing class to generate final file with list of sorted and counted
			// symptoms
			WriteFileSymptomsData fileWriterClass = new WriteFileSymptomsData();
			fileWriterClass.writeSymptomsData(symptoms);

			// Display final result in console
			for (Map.Entry<String, Integer> entry : symptoms.entrySet())
				System.out.println(entry.getKey() + ": " + entry.getValue());

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}