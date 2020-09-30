package com.hemebiotech.analytics;

public class MainClass {

	public static void main(String[] args) {
		ISymptomReader symptomsReader = new ReadSymptomDataFromFile();
		Analytics analyticsCounter = new AnalyticsCounter();
		ISymptomWriter symptomsWriter = new WriteMapSymtomDataInFile();
		FileManager fileManager = new FileManager(symptomsReader, analyticsCounter, symptomsWriter);
		
		fileManager.readFile("Project02Eclipse\\symptoms.txt");
		fileManager.analyzeDatas();
		fileManager.writeDatasInFile();
	}

}
