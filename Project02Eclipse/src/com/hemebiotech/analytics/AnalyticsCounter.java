package com.hemebiotech.analytics;


public class AnalyticsCounter {

	
	public static void main(String args[]) throws Exception {

		ReadSymptomDataFromFile symptomsListNotSort = new ReadSymptomDataFromFile("Project02Eclipse/symptoms.txt");
		SortListAlphabetically symptomsListSort = new SortListAlphabetically(symptomsListNotSort.GetSymptoms());
		new WriteResult(symptomsListSort.SortList());

	}
}
