package com.hemebiotech.analytics;

/**
 * @author Fatima
 * 
 *         Class that contains main to execute the program
 */

public class Application {

	public static void main(String args[]) {

		String currentDir = System.getProperty("user.dir");
		ISymptomReader symptomList = new ReadSymptomDataFromFile(currentDir + "/Project02Eclipse/symptoms.txt");
		IAnalyticsCounter symptomCounter = new AnalyticsCounter(symptomList.getSymptoms());
		ISymptomWriter resultOutput = new WriteSymptomDataToFile(symptomCounter.getSymptomsOccurences(),
				currentDir + "/Project02Eclipse/results.out");

		resultOutput.generateOutputFile();
	}
}
