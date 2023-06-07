package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class AnalyticsCounter {

	ISymptomReader reader;
	ISymptomWriter writer;

	String filepathIn = ".\\Project02Eclipse\\symptoms.txt";
	String filepathOut = ".\\Project02Eclipse\\result.out";

	// Constructor of AnalyticsCounter()
	public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer) {
		this.reader = reader;
		this.writer = writer;
	}

	public List<String> getSymptoms() {
		List<String> result = new ArrayList<String>();

		if (filepathIn != null) {
			try {
				BufferedReader reader = new BufferedReader(new FileReader(filepathIn));
				String line = reader.readLine();

				while (line != null) {
					result.add(line);
					line = reader.readLine();
				}
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	public Map<String, Integer> countSymptoms(List<String> listSymptoms) {
		Map<String, Integer> symptoms = new HashMap<>();

		Integer count = 0;
		// read the file symptoms.txt and put the values in a hashmap (called symptoms)

		for (String str : listSymptoms) {
			if (symptoms.containsKey(str)) { // is true if hashmap contains the symptom from the list symptoms.txt
				count = symptoms.get(str) + 1; // increment if symptom is already in the hashmap
				symptoms.put(str, count); // insert the count of symptom for the symptom
			} else {
				count = 1; // if the symptom is unknown, the symptom is put in the hashmap
				symptoms.put(str, count);
			}
		}
		return symptoms;
	}

	public Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms) {
		Map<String, Integer> result = new HashMap<>();
		Map<String, Integer> sortList = new TreeMap<>(symptoms); // TreeMap is
		for (String str : sortList.keySet()) {
			result.put(str, sortList.get(str));
		}
		return result;
	}

	public void writeSymptoms(Map<String, Integer> symptoms) {
		try {
			FileWriter writer = new FileWriter(filepathOut); // create the file result.out

			for (Map.Entry<String, Integer> entry : symptoms.entrySet()) {
				writer.write(entry.getKey().toString() + " " + entry.getValue() + "\n");
			}
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String args[]) throws Exception {

	}

}
