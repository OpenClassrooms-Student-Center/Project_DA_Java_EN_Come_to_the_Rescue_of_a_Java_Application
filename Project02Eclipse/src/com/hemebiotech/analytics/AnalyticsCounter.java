package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.util.ArrayList;

public class AnalyticsCounter {
	
	public static void main(String args[]) throws Exception {

		// Liste des symptomes
		ArrayList<String> listSymptomes = new ArrayList<String>();

		// first get input
		ReadSymptomDataFromFile fichierLu = new ReadSymptomDataFromFile("./Project02Eclipse/symptoms.txt");
		listSymptomes = fichierLu.GetSymptoms();

		int i = 0;	// set i to 0

		while (i < listSymptomes.size()) {
			System.out.println("symptom from file: " + listSymptomes.get(i));
			i++;
		}
		
		// next generate output
		FileWriter writer = new FileWriter ("result.out");
		writer.close();
	}
}