package com.hemebiotech.analytics;

import java.util.List;

public class AnalyticsCounter {

	
	public static void main(String args[]) throws Exception {
		
		
		ReadSymptomDataFromFile readSymptomDataFromFile = new ReadSymptomDataFromFile("Project02Eclipse/symptoms.txt");
		List<String> listOfSymptom = readSymptomDataFromFile.getSymptoms();
		
		
	}
}
