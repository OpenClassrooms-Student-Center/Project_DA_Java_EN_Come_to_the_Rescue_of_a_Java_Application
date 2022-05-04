package com.hemebiotech.analytics;

import java.util.HashMap;
import java.util.List;

public class AnalyticsCounter {
	public HashMap<String, Integer> symptomsReaderAndStorer(){
		try {
			HashMap<String, Integer> symptomsMap = new HashMap<String, Integer>();
			ReadSymptomDataFromFile readData = new ReadSymptomDataFromFile("Project02Eclipse/symptoms.txt");
			List<String> listSymptoms = readData.GetSymptoms();
			
			for (String symptom : listSymptoms  ) {	
				symptomsMap.put(symptom, symptomsMap.getOrDefault(symptom, 0) + 1);		
			}
			for(String i: symptomsMap.keySet()) {
				System.out.println("key: " + i + " value: " + symptomsMap.get(i));
			}
			return symptomsMap;
		}
		catch(Exception e){
			System.out.println("");
		}
		return null;
	}
	public HashMap <String, Integer> alphaSorting(HashMap<String, Integer> map){
		
		return null;
	}
	public static void main(String args[]) throws Exception {
		AnalyticsCounter listSymptomsMap = new AnalyticsCounter() ;
		HashMap<String, Integer> map = listSymptomsMap.symptomsReaderAndStorer();
		listSymptomsMap.alphaSorting(map);
		
		
	}
}
