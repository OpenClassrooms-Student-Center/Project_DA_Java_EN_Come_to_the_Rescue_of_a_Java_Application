package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class AnalyticsCounter {
	private static int headacheCount = 0;
	private static int rashCount = 0;
	private static int pupilCount = 0;
	static File documentToParse = new File("symptoms.txt");
	static List<String> listOfSymptoms = new ArrayList<String>();
	static HashSet<String> uniqueOccurence = new HashSet<String>();
	static HashMap<String, Integer> symptomeFrequencyMap = new HashMap<String, Integer>();
	
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
		
		parsingFile(documentToParse, listOfSymptoms, uniqueOccurence);
		countingSymptoms(symptomeFrequencyMap, listOfSymptoms);
		
		// next generate output
		FileWriter writer = new FileWriter ("result.out");
		writer.write("headache: " + headacheCount + "\n");
		writer.write("rash: " + rashCount + "\n");
		writer.write("dialated pupils: " + pupilCount + "\n");
		writer.close();
	}

	
	// First parse the document and get a List of symptoms and a HashSet to count unique occurrences
	public static void parsingFile(File documentToParse, List<String> listOfSymptoms, HashSet<String> uniqueOccurrence) {
		if(documentToParse != null) {
			try {
				
				BufferedReader parsedFile = new BufferedReader (new FileReader(documentToParse));
				String symptom = parsedFile.readLine();
				
				while (symptom != null) {
					listOfSymptoms.add(symptom);
					uniqueOccurrence.add(symptom);
					symptom = parsedFile.readLine();
				}
				parsedFile.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	// Method that will count each occurrence of a symptom
	// It will check if a symptom is already in the HashMap as a key
	// If true it will add 1 to the counter, else it will create the key and initialize it at 1
	public static void countingSymptoms(HashMap<String, Integer> symptomeFrequencyMap, List<String> listOfSymptoms) {
		
		// Iterate over the list of symptoms
		for(String symptom : listOfSymptoms) {
			if(symptomeFrequencyMap.containsKey(symptom)) {
				symptomeFrequencyMap.put(symptom, symptomeFrequencyMap.get(symptom) + 1);
			}
			else {
				symptomeFrequencyMap.put(symptom, 1);
			}
		}
		System.out.println("FrequencyMap " + symptomeFrequencyMap);
	}
	
}
