package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Collections;
import java.util.List;

public class AnalyticsCounter {
	private static int headacheCount = 0;	// initialize to 0
	private static int rashCount = 0;		// initialize to 0
	private static int pupilCount = 0;		// initialize to 0
	
	public static void main(String args[]) throws Exception {
		// first get input
		try {
		// Read from data source
		List <String> listSymptoms = read("symptoms.txt");
		System.out.println(listSymptoms);
		} catch (Exception e) {
			System.out.println("Error occured : " + e);
		}

		int i = 0;
		int headCount = 0;
		String line;
		while (line != null) {
			i++;
			System.out.println("symptom from file: " + line);
			if (line.equals("headache")) {
				headCount++;
				System.out.println("number of headaches: " + headCount);
			}
			else if (line.equals("rush")) {
				rashCount++;
			}
			else if (line.contains("pupils")) {
				pupilCount++;
			}

		}
	}
		
	// Return a list with data symptoms
	static List<String> read(String nomFichier){
		ISymptomReader symptoms = new ReadSymptomDataFromFile(nomFichier);
		List<String> listSymptoms = symptoms.getSymptoms();
		Collections.sort(listSymptoms);
		return listSymptoms;
	}
		// next generate output
		FileWriter writer = new FileWriter ("results.out");
		writer.write("headache: " + headacheCount + "\n");
		writer.write("rash: " + rashCount + "\n");
		writer.write("dialated pupils: " + pupilCount + "\n");
		writer.close();
}

