package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AnalyticsCounter {
	
	static File documentToParse = new File("symptoms.txt");
	
	static List<String> listOfSymptoms = new ArrayList<String>();
	static HashMap<String, Integer> symptomeFrequencyMap = new HashMap<String, Integer>();
	
	static FileWriter resultsDocument;
	
	public static void main(String args[]) throws Exception {
		
		resultsDocument = new FileWriter("result.out");
		
		parsingFile(documentToParse, listOfSymptoms);
		countingSymptoms(symptomeFrequencyMap, listOfSymptoms);
		writingFile(resultsDocument, symptomeFrequencyMap);
		
	}

	
	// First parse the document and get a List of symptoms and a HashSet to count unique occurrences
	public static void parsingFile(File documentToParse, List<String> listOfSymptoms) throws IOException{
		if(documentToParse != null) {
			try {
				
				BufferedReader parsedFile = new BufferedReader (new FileReader(documentToParse));
				String symptom = parsedFile.readLine();
				
				while (symptom != null) {
					listOfSymptoms.add(symptom);
					symptom = parsedFile.readLine();
				}
				parsedFile.close();
			} catch (IOException e) {
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
	
	// This method will write the document 
	public static void writingFile(FileWriter resultsDocument, HashMap<String, Integer> symptomeFrequencyMap) throws IOException{
		for(String symptom : symptomeFrequencyMap.keySet()) {
			try {
				resultsDocument.write(symptom + ": "  + symptomeFrequencyMap.get(symptom) +  "\n");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		resultsDocument.close();
	}
	
}
