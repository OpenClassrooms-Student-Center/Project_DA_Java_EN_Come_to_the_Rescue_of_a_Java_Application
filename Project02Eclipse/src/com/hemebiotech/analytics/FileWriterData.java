package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.TreeMap;

public class FileWriterData {

	/**
	 * @return file with sorted and counted symptoms
	 * 
	 */

	public void writeSymptomsData() throws IOException {
		try {

			// Call Sorting class
			SortSymptomsData symptomsSorting = new SortSymptomsData();
			TreeMap<String, Integer> symptoms = symptomsSorting.sortingSymptomsData();

			// Create FileWriter to create a file with sorted and counted symptoms in it
			FileWriter symptomswriter = new FileWriter("SymptomsList.txt");
			symptomswriter.write("Symptoms List " + symptoms);

			// Close Filewriter
			symptomswriter.close();

		} catch (IOException e) {
			e.printStackTrace();

		}

	}

}