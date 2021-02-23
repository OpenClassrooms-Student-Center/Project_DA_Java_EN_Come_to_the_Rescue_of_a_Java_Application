package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;

public class AnalyticsCounter {
	private static int headacheCount = 0;	// initialize to 0
	private static int rashCount = 0;		// initialize to 0
	private static int pupilCount = 0;		// initialize to 0
	
	public static void main(String args[]) throws Exception {
		// first get input
		BufferedReader reader = new BufferedReader (new FileReader("symptoms.txt"));
		String line = reader.readLine();

		HashMap<String, Integer> symptoms = new HashMap<>();
		int i = 0;	// set i to 0
		while (line != null) {
			i++;	// increment i
			System.out.println("symptom from file: " + line);

			if (symptoms.containsKey(line)) {
				symptoms.put(line, symptoms.get(line)+1);
			} else {
				symptoms.put(line, 1);
			}

			line = reader.readLine();	// get another symptom
		}

		// next generate output
		FileWriter writer = new FileWriter ("result.out");
		for (String s: symptoms.keySet()) {
			writer.write(s + " : " + symptoms.get(s) + "\n");
		}
		writer.close();
	}
}
