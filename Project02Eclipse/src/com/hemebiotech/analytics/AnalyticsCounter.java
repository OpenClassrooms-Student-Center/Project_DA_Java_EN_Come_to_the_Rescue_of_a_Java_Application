package com.hemebiotech.analytics;



public class AnalyticsCounter {
	
	
	public static void main(String args[]) throws Exception {
		
		ReadSymptomDataFromFile listSymptom = new ReadSymptomDataFromFile();
		
		SymptomOut.editFinalFile(SymptomCounter.countOccurences(listSymptom));
		
		
		 
		
		
		}
	
}
