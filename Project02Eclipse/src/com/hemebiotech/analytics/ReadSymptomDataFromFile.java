package com.hemebiotech.analytics;

import java.io.BufferedReader;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/**
 * Simple brute force implementation
 * ISymptomReader interface implementation 
 */
public class ReadSymptomDataFromFile implements ISymptomReader {
		

		/* 
		 * Get an access to the data file "Symptom.txt" and return result in a list of symptom
		 */
	
		public List<String> GetSymptoms(String filename) throws IOException {
			
			System.out.println("Lecture du fichier : " + filename);
			
			BufferedReader symptom = new BufferedReader (new FileReader(filename));
			
			List<String> symptoms = new ArrayList<String>();
			
		
			
			String line = symptom.readLine();
			
			while (line !=null) {
				
	
				symptoms.add(line);
				
				line = symptom.readLine();
			}
			
			return symptoms;
		} } 



