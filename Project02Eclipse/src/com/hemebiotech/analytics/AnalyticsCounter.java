package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.List;

public class AnalyticsCounter {
	public static void main(String args[]) throws Exception {
		try (
				BufferedReader reader = new BufferedReader (new FileReader("Project02Eclipse/symptoms.txt"));
				FileWriter writer = new FileWriter("result.out")
			) {
			
	
			String line = reader.readLine();
			Hashtable<String, Integer> symptoms = new Hashtable<String, Integer>();
			
			while (line != null) {
				if (symptoms.containsKey(line)) {
					symptoms.put(line, symptoms.get(line) + 1);
				} else {
					symptoms.put(line, 1);
				}
				line = reader.readLine();
			}
	
			Enumeration<String> symptomsKeys = symptoms.keys();
			List<String> sortsymptomsKeys = new ArrayList<String>();
			
			while(symptomsKeys.hasMoreElements()) {
		    	String key = symptomsKeys.nextElement();
		    	sortsymptomsKeys.add(key);
		    }
			
			Collections.sort(sortsymptomsKeys);
			
			for (String symptomKey : sortsymptomsKeys) {
				writer.write(symptomKey.substring(0, 1).toUpperCase() + symptomKey.substring(1) + " : " + symptoms.get(symptomKey) + "\n");
			}
		} catch (IOException e) {
			  e.printStackTrace();
		}
	}
}
