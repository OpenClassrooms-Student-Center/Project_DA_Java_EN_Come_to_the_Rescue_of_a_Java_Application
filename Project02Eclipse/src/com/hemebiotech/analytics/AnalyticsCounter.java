package com.hemebiotech.analytics;


import java.util.List;

public class AnalyticsCounter {	
	
	public static void main(String args[]) throws Exception {
		
		
		ReadSymptomDataFromFile readSyptoms = new ReadSymptomDataFromFile("symptoms.txt");
		List<String> ListSymptoms = readSyptoms.GetSymptoms();
		
		WriteSymptomDataToFile writeSymptoms = new WriteSymptomDataToFile(ListSymptoms);
		writeSymptoms.writeSymptoms();
		
		
	}
}
