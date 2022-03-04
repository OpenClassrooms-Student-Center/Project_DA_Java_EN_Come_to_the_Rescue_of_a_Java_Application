package com.hemebiotech.analytics;

import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class AnalyticsCounter {

	public static void main(String[] args) throws IOException {

		// Call writer class to write final result in file
		FileWriterData symptomsfile = new FileWriterData();
		symptomsfile.writeSymptomsData();

		// Display result of sorting class to check final result in console
		SortSymptomsData consoleOutput = new SortSymptomsData();
		TreeMap<String, Integer> symptoms = consoleOutput.sortingSymptomsData();
		for (Map.Entry<String, Integer> entry : symptoms.entrySet())
			System.out.println("Symptoms : " + entry.getKey() + ": " + entry.getValue());

	}

}