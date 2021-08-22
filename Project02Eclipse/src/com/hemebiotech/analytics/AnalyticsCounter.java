package com.hemebiotech.analytics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AnalyticsCounter {

	
	public static void main(String args[]) throws Exception {
		// first get input
		
		Map<String, Integer> symptoms = new HashMap<>();
		
		ISymptomReader reader = new ReadSymptomDataFromFile("C:\\\\Users\\\\Chilioa\\\\Desktop\\\\OpenClassRoom\\\\Project_DA_Java_EN_Come_to_the_Rescue_of_a_Java_Application\\\\Project02Eclipse\\\\symptoms.txt");
		List<String> listeSymptomsBrute = reader.GetSymptoms();
		List<String> listeSymptoms = new ArrayList<>();
		for (String line : listeSymptomsBrute) {
	       if(symptoms.containsKey(line))
			symptoms.put(line,symptoms.get(line)+1);
	       else {
	    	symptoms.put(line,1);
	       listeSymptoms.add(line);
	       }

			
		}
		for (String symptom : symptoms.keySet()) {
			System.out.println(symptom + "  " + symptoms.get(symptom));
		}
		
		// next generate output
		Collections.sort(listeSymptoms);
		ISymptomWriter Writer = new WriteSymptomsInFile();
		Writer.symptomsWriter(symptoms, listeSymptoms);
	}
}
