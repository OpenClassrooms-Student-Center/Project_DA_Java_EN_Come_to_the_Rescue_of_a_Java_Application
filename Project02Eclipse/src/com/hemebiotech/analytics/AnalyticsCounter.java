package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

public class AnalyticsCounter {

	public static void main(String args[]) throws Exception {

		ReadSymptomDataFromFile readSymptomDataFromFile = new ReadSymptomDataFromFile("Project02Eclipse/symptoms.txt");
		List<String> listOfSymptom = readSymptomDataFromFile.getSymptoms();

		SymptomCounter symptomCounter = new SymptomCounter();
		Map<String, Integer> finalCount = symptomCounter.listToMap(listOfSymptom);
		
		WriteFinalDataFile writeFinalDataFile= new WriteFinalDataFile("Project02Eclipse/results.out");
		writeFinalDataFile.writeData(finalCount);
		

	}
}
