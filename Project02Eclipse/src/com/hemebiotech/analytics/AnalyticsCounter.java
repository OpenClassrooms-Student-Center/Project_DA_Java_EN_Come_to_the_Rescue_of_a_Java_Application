package com.hemebiotech.analytics;

import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class AnalyticsCounter {

	public static void main(String[] args) throws IOException {

		// Call Writer class to write list of sorted and counted symptoms in file
		FileWriterData symptomsfile = new FileWriterData();
		symptomsfile.writeSymptomsData();

		// Display result of sorting class to check final result in Console
		SortSymptomsData consoleOutput = new SortSymptomsData();
		TreeMap<String, Integer> symptoms = consoleOutput.sortingSymptomsData();
		for (Map.Entry<String, Integer> entry : symptoms.entrySet())
			System.out.println("List of Symptoms : " + entry.getKey() + ": " + entry.getValue());

	}

}
