package com.hemebiotech.analytics;

import java.util.List;
import java.util.TreeMap;
import java.util.TreeSet;


public class MainClass {

	public static void main(String... args) {
		ISymptomAnalyser analytics = new AnalyseSymptoms();
		List<String> symptoms = analytics.getSymptoms();
		TreeSet<String> sortedSymptoms = analytics.sortSymptoms(symptoms);
		TreeMap<String,Integer> mappedSymptoms = analytics.countSymptoms(symptoms, sortedSymptoms);
		analytics.writeSymptom(mappedSymptoms);
	}
}