package com.hemebiotech.analytics;

import java.util.ArrayList;

public class AnalyticsCounter {
	
	public static void main(String args[]) throws Exception {

		// List of symptoms
		ArrayList<String> listSymptomes = new ArrayList<String>();

		// Get input
		ReadSymptomDataFromFile fichierLu = new ReadSymptomDataFromFile("./Project02Eclipse/symptoms.txt");
		listSymptomes = fichierLu.GetSymptoms();
		
		// Generate output
		WriteSymptomData fichierOut = new WriteSymptomData();
		fichierOut.WriteSymptoms(listSymptomes);
	}
}