package com.hemebiotech.analytics;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

/**
 * Main class designed to input file path and for successively launching
 * reading, sorting and writing classes and checking result in console
 * 
 * @author CHRISTINE TETI
 *
 */
public class AnalyticsCounter {

	public static void main(String[] args) throws Exception {
		try {
			// Call Interface, use reading class and pass file path
			ISymptomReader fileReaderClass = new ReadSymptomDataFromFile("Project02Eclipse/symptoms.txt");
			ArrayList<String> result = fileReaderClass.getSymptoms();

			// Call sorting class with return of reading class as argument
			SortSymptomsData sortingClass = new SortSymptomsData();
			TreeMap<String, Integer> symptoms = sortingClass.sortingSymptomsData(result);

			// Call writing class to generate final file with list of sorted and counted
			// symptoms
			WriteSymptomFile fileWriterClass = new WriteSymptomFile();
			fileWriterClass.writeSymptomData(symptoms);

			// Display final result in console
			for (Map.Entry<String, Integer> entry : symptoms.entrySet())
				System.out.println(entry.getKey() + ": " + entry.getValue());

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}