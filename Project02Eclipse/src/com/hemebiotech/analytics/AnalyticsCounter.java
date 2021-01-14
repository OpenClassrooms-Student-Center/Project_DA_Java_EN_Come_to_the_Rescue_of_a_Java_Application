package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class AnalyticsCounter {

	public static void main(String[] args) throws IOException {

		try {

			// read file symptoms
			BufferedReader reader = new BufferedReader(new FileReader("Project02Eclipse/symptoms.txt"));
			String line = reader.readLine();

			Map<String, Integer> symptomOccurrence = new HashMap<>();

			while (line != null) {
				line = reader.readLine();
				if (symptomOccurrence.containsKey(line)) {
					symptomOccurrence.put(line, symptomOccurrence.get(line) + 1);
				} else {
					symptomOccurrence.put(line, 1);
				}
			}
			reader.close();

			System.out.println(symptomOccurrence.toString());

		} catch (IOException e) {
			e.printStackTrace();

		}
	}
}
