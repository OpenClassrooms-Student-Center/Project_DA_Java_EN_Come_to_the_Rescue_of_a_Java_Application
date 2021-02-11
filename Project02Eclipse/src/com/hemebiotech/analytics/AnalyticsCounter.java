package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;


public class AnalyticsCounter {
	private static int headacheCount = 0;	// initialize to 0
	private static int rashCount = 0;		// initialize to 0
	private static int pupilCount = 0;		// initialize to 0
	
	public static void main(String args[]) throws Exception {
		
		
		// first get input
		File symptomsFile = new File ("Project02Eclipse/symptoms.txt");	
		BufferedReader reader = new BufferedReader (new FileReader(symptomsFile.getCanonicalPath()));
		
		
		// import de la classe ReadSymptomDataFromFile + instanciation dans reader1.
		//
		//
		 
		
		String line = reader.readLine();
		ReadSymptomDataFromFile reader1 = new ReadSymptomDataFromFile();
		

		int i = 0;

		while (line != null) {
			i++;

			if (line.equals("headache")) {
				headacheCount++;
			}
			else if (line.equals("rash")) {
				rashCount++;
			}
			else if (line.contains("pupils")) {
				pupilCount++;
			}
			line = reader.readLine();	// get another symptom
		}
		
		// next generate outpu
		File file = new File ("result.out");
		FileWriter writer = new FileWriter ("result.out");
		writer.write("headache: " + headacheCount + "\n");
		writer.write("rash: " + rashCount + "\n");
		writer.write("dialated pupils: " + pupilCount + "\n");
		writer.close();
	}
}
