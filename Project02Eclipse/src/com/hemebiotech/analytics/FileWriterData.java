package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.TreeMap;

public class FileWriterData {

	public void writeSymptomsData() throws IOException {
		try {

			// Call of sorting class
			SortSymptomsData symptomsSorting = new SortSymptomsData();
			TreeMap<String, Integer> symptoms = symptomsSorting.sortingSymptomsData();

			// Create a FileWriter
			FileWriter symptomswriter = new FileWriter("SymptomsList.txt");
			symptomswriter.write("Symptoms List " + symptoms);

			// Close the writer
			symptomswriter.close();

		} catch (IOException e) {
			e.printStackTrace();

		}

	}

}