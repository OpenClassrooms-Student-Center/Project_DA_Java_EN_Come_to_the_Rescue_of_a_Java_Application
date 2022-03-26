package com.hemebiotech.analytics;

/**
 * @author Fatima
 * 
 *         Class that contains main to execute the program
 */

public class Application {

	public static void main(String args[]) throws Exception {

		String currentDir = System.getProperty("user.dir");
		ISymptomReader symptomList = new ReadSymptomDataFromFile(currentDir + "/Project02Eclipse/symptoms.txt");
		IAnalyticsCounter symptomCounter = new AnalyticsCounter(symptomList.getSymptoms());
		ISymptomWriter resultOutput = new WriteSymptomDataToFile(symptomCounter.getSymptomsOccurrences(),
				currentDir + "/Project02Eclipse/results.out");

		resultOutput.generateOutputFile();
	}
}
