package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

/**
 * @author DOLLOU 
 * @since 09/02/2021
 *  
 */

public class AnalyticsCounter {
	
	final static String INPUT = "Project02Eclipse/symptoms.txt";
	final static String OUTPUT = "Project02Eclipse/results.out";
	

	public static void main(String args[]) throws Exception {
/**
 * 
 */
		ISymptomReader readSymptomDataFromFile = new ReadSymptomDataFromFile(INPUT);
		List<String> listOfSymptom = readSymptomDataFromFile.getSymptoms();

		SymptomCounter symptomCounter = new SymptomCounter();
		Map<String, Integer> finalCount = symptomCounter.listToMap(listOfSymptom);
		
		IWriteFinalDataFile writeFinalDataFile= new WriteFinalDataFile(OUTPUT);
		writeFinalDataFile.writeData(finalCount);
		

	}
}
