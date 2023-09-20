package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class AnalyticsCounter {
	private static int headacheCount = 0;
	private static int rashCount = 0;
	private static int pupilCount = 0;

	private ISymptomReader reader;
	private ISymptomWriter writer;

	public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer) {
		this.reader = reader;
		this.writer = writer;
	}

	public List<String> getSymptoms() {
		return this.reader.GetSymptoms();
	}
	
	public Map<String, Integer> countSymptoms(List<String> symptoms){
		Map<String, Integer> countSymptoms = new HashMap<String, Integer>();
		for (String symptom : symptoms) {
			if (countSymptoms.containsKey(symptom)){
				int value = countSymptoms.get(symptom)+1;
				countSymptoms.put(symptom, value);
			} else 
				countSymptoms.put(symptom,1);
		}
		return countSymptoms;	
	}
	
	public Map<String, Integer> sortSymptoms (Map<String, Integer> symptoms){
		return new TreeMap<>(symptoms);
	}
	
	public void writeSymptoms(Map<String, Integer> symptoms) {
		this.writer.writeSymptoms(symptoms);
	}
	
	public static void main(String args[]) throws Exception {
		// first get input
		BufferedReader reader = new BufferedReader(new FileReader("symptoms.txt"));
		String line = reader.readLine();

		int i = 0;
		int headCount = 0;
		while (line != null) {
			i++;
			System.out.println("symptom from file: " + line);
			if (line.equals("headache")) {
				headCount++;
				System.out.println("number of headaches: " + headCount);
			} else if (line.equals("rash")) {
				rashCount++;
			} else if (line.contains("pupils")) {
				pupilCount++;
			}

			line = reader.readLine(); // get another symptom
		}

		// next generate output

		WriteSymptomDataToFile writeSymptomDataToFile;
		writeSymptomDataToFile = new WriteSymptomDataToFile();
		Map<String, Integer> symptoms = new HashMap<>();
		symptoms.put("headache", headCount);
		symptoms.put("rash", rashCount);
		symptoms.put("pupils", pupilCount);
		writeSymptomDataToFile.writeSymptoms(symptoms);

	}
}
