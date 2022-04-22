package com.hemebiotech.analytics;

import java.io.IOException;
import java.util.Map;

public class AnalyticsCounter {
	private static final String INPUT_FILE = "symptoms.txt";
	private static final String OUTPUT_FILE = "result.out";
	public static void main(String[] args) {
		try {
			Map<String, Integer> symptoms = new SymptomsReader().read(INPUT_FILE);
			SymptomsWriter symptomsWriter = new SymptomsWriter();
			symptomsWriter.write(symptoms, OUTPUT_FILE);
		} catch (IOException e){
			System.err.println(e.getMessage());
		}
	}
}