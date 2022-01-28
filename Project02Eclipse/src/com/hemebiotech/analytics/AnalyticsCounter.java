package com.hemebiotech.analytics;

import java.util.Map;

public class AnalyticsCounter {
	
	public static final String INPUT_FILE = "./Project02Eclipse/symptoms.txt";
	public static final String OUTPUT_FILE = "results.out";

	public static void main(String args[]) {

		Map<String, Integer> listSymptomsOut;
		
		// Get, sort and count Input
		SortSymptoms sortedSymptoms = new SortSymptoms();
		listSymptomsOut = sortedSymptoms.sortAndCountSymptoms(INPUT_FILE);

		// Generate output file
		WriteSymptomData fichierOut = new WriteSymptomData(OUTPUT_FILE);
		fichierOut.WriteSymptoms(listSymptomsOut);

	};

}