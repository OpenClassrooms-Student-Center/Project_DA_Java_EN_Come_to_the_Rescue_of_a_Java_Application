package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class AnalyticsCounter {
	public static void main(String args[]) throws Exception {
		try (
				BufferedReader reader = new BufferedReader (new FileReader("Project02Eclipse/symptoms.txt"));
				FileWriter writer = new FileWriter("result.out")
			) {
	
			String line = reader.readLine();
			Map<String, Integer> symptoms = new TreeMap<String, Integer>();
			
			while (line != null) {
				line = line.toLowerCase();
				line = line.trim();
				if (symptoms.containsKey(line)) {
					symptoms.put(line, symptoms.get(line) + 1);
				} else {
					symptoms.put(line, 1);
				}
				line = reader.readLine();
			}
			
			Map<String, Integer> treeMap = new TreeMap<String, Integer>(symptoms);
			for (Map.Entry<String, Integer> entry : treeMap.entrySet()) {
	            writer.write(entry.getKey() + " : " + entry.getValue() + "\n");
	        }
			
		} catch (IOException e) {
			  e.printStackTrace();
		}
	}
}
