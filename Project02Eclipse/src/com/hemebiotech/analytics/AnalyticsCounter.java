package com.hemebiotech.analytics;


public class AnalyticsCounter {	
	

	public static void main(String args[]) throws Exception {
		
		ReadSymptomDataFromFile symptomsListNotSort = new ReadSymptomDataFromFile("Project02Eclipse/symptoms.txt");
		SortSymptomFromList symptomsListSort = new SortSymptomFromList(symptomsListNotSort.GetSymptoms());
		CountSymptomFromList symptomsMap = new CountSymptomFromList(symptomsListSort.SortSymptoms());
		new WriteSymptomFromMap(symptomsMap.CountSymptoms(), symptomsListSort.SortSymptoms()).WriteSymptoms();
	}
}
