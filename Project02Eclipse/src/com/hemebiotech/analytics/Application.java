package com.hemebiotech.analytics;

/**
 * @author Fatima
 * 
 *         Class that contains main to execute the program
 */

public class Application {

	public static void main(String args[]) {

		String currentDir = System.getProperty("user.dir");
		String dir = currentDir + "/Project02Eclipse/symptoms.txt";
		ISymptomReader symptomList = new ReadSymptomDataFromFile(dir);
		IAnalyticsCounter symptomCounter = new AnalyticsCounter(symptomList.getSymptoms());
		ISymptomWriter resultOutput = new WriteSymptomDataToFile(symptomCounter.getSymptomsOccurrences(),
				currentDir + "/Project02Eclipse/results.out");

		resultOutput.generateOutputFile();
	}
}
