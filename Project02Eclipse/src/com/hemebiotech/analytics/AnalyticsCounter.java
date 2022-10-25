package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AnalyticsCounter {
	private static int headacheCount = 0;
	private static int rashCount = 0;
	private static int pupilCount = 0;
	
	public static void main(String args[]) throws Exception {

		
		/* 
		int i = 0;
		int headCount = 0;	// counts headaches
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
			
			line = reader.readLine();	// get another symptom
		}
		
		reader.close(); 
		*/ 
		
		// next generate output
		FileWriter writer = new FileWriter ("result.out");
		writer.write("headache: " + headacheCount + "\n");
		writer.write("rash: " + rashCount + "\n");
		writer.write("dialated pupils: " + pupilCount + "\n");
		writer.close();
	}

	// first get input
	public static void parsingFile(File doc, List<String> listOfSymptoms, ArrayList<String> uniqueOccurence) {
		if(doc != null) {
			try {
				
				BufferedReader parsedFile = new BufferedReader (new FileReader(doc));
				String symptom = parsedFile.readLine();
				
				while (symptom != null) {
					listOfSymptoms.add(symptom);
					uniqueOccurence.add(symptom);
				}
				parsedFile.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	// method that will only save one copy of each symptom
	
	// public static 
	
	// method that will count each occurrence of a symptom
	public static void countingSymptoms() {
		
		int counter = 0;
	}
}
