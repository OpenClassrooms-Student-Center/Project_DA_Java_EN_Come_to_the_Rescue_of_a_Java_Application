package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class AnalyticsCounterEdit {

	
	public static void main(String args[]) {
		
		//Create HashMap to contain map of Symptom:Occurrences
		HashMap<String, Integer> symptoms = new HashMap<String, Integer>();
		

		//Read input from file into HashMap
		try {
			BufferedReader reader = new BufferedReader (new FileReader("symptoms.txt"));
			String line = reader.readLine();
			

			while (line != null) {
				//If symptom already exists in HashMap, increase occurrence by 1
				if (symptoms.containsKey(line)) {
					int value = symptoms.get(line);
					symptoms.put(line, value + 1);
					System.out.println("Adding duplicate");
				}
				//Otherwise, add symptom and set occurrence to 1
				else {
					symptoms.put(line, 1);
					System.out.println("Adding new");
				}
				//Get next symptom from reader
				line = reader.readLine();	
			}		
			reader.close();
		}
		catch (FileNotFoundException e) {
			//Catch cases where symptoms file is not in the expected location
			System.err.println("File not found: symptoms.txt");
		}
		catch (IOException e) {
			//Catch any other IO errors
			System.err.println("IO Error: " + e);
		}
		
		//Output symptom counts to file
		
		try {
			FileWriter writer = new FileWriter ("resultSorted.out");
			//Iterate through HashMap, write each symptom & occurrence number to file
			Map<String, Integer> sorted = new TreeMap<>(symptoms);
			
			for (Map.Entry<String, Integer> set : sorted.entrySet()) {
				System.out.println(set.getKey() + " = " + set.getValue());
				writer.write(set.getKey() + " = " + set.getValue() + "\n");
			}
			
			writer.close();
			System.out.println("Total number of different symptoms: " + symptoms.size());
		}
		catch (IOException e) {
			//Catch any IO errors that may occur
			System.err.println("IO Error: " + e);
		}
		
		
		
	}
}
