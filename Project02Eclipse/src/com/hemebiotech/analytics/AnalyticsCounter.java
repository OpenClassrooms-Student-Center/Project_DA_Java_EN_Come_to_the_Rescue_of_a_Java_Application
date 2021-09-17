package com.hemebiotech.analytics;

import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

/**
 * contains the main
 * 
 * @author didier
 *
 */
public class AnalyticsCounter {

	public static void main(String[] args) throws IOException {

		/**
		 * Call of the FileWriterData class to write to the file: "results.out".
		 */

		FileWriterData finalResult = new FileWriterData();
		finalResult.writeSymptomsData();

		/**
		 * Call the TreeMap and display in the console to check that the output is good.
		 */

		ExtracSymptomData consoleOutput = new ExtracSymptomData();
		TreeMap<String, Integer> symptoms = consoleOutput.extracSymptomsData();
		for (Map.Entry<String, Integer> entry : symptoms.entrySet())
			System.out.println("- " + entry.getKey() + ": " + entry.getValue());
	}

}