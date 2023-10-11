package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Map;
import java.util.HashMap;

public class AnalyticsCounter {

	private static Map<String, Integer> symptoms = new HashMap<String, Integer>();

	public static void lookForKeyInMap(Map<String, Integer> map, String symptom) {
		boolean isInMap=false; //to track if we found the symptom in the map
		for (String key : map.keySet()) {
			if(symptom.equals(key)){
				map.put(key, map.get(key)+1);
				isInMap=true;
			}
		}
		if(!isInMap){
			map.put(symptom, 1);
		}
	}


	public static void main(String args[]) throws Exception {
		// first get input
		BufferedReader reader = new BufferedReader (new FileReader("symptoms.txt"));
		String line = reader.readLine();

		while (line != null) {
			lookForKeyInMap(symptoms, line);
			line = reader.readLine();	// get another symptom
		}
		for(Map.Entry<String, Integer> entry : symptoms.entrySet()){
			System.out.println(entry.getKey() + "->" + entry.getValue());
		}
		// next generate output
		FileWriter fileWriter = new FileWriter ("result.out");
		BufferedWriter writer = new BufferedWriter(fileWriter);
		for(Map.Entry<String, Integer> entry : symptoms.entrySet()){
			writer.write(entry.getKey() + ": " + entry.getValue());
			writer.newLine();
		}
		writer.close();
	}
}
