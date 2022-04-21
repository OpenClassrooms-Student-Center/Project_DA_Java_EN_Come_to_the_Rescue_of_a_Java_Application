package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Map;

public class AnalyticsCounter {
	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader (new FileReader("symptoms.txt"));
		String line = reader.readLine();
		Map<String, Integer> symptoms = new HashMap<>();

		while (line != null) {
			if (!symptoms.containsKey(line)) {
				symptoms.put(line, 1);
			} else {
				symptoms.put(line, symptoms.get(line) + 1);
			}
			line = reader.readLine();
		}

		FileWriter writer = new FileWriter ("result.out");
		writer.write(symptoms + "\n");
		writer.close();
	}
}

