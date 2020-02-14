package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Hashtable;

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
			
			while(symptomsKeys.hasMoreElements()) {
		    	String key = symptomsKeys.nextElement();
		    	writer.write(key + " : " + symptoms.get(key) + "\n");
		    }
		} catch (IOException e) {
			  e.printStackTrace();
		}
	}
}
