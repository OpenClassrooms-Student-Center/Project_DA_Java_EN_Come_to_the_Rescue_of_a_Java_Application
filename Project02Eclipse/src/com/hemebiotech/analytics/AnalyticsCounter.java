package com.hemebiotech.analytics;

import java.util.Map;

public class AnalyticsCounter {
	public static void main(String args[]) throws Exception {
		ReadSymptomsDataFromFile symptomsFileReader = new ReadSymptomsDataFromFile("Project02Eclipse/symptoms.txt");
		WriteSymptomsDataToFile symptomsFileWriter = new WriteSymptomsDataToFile("result.out");
		
		symptomsFileWriter.writeSymptoms(symptomsFileReader.GetSymptoms());
	}
}