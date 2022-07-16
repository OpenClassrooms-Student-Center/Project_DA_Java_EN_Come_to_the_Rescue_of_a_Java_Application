package com.hemebiotech.analytics;

import java.util.List;
import java.util.TreeMap;
import java.util.TreeSet;


public class AnalyticsCounter {

	public static void main(String... args) {
		//step 1: read symptom data from file and get a raw listing of symptoms
		ISymptomReader symptomReader = new ReadSymptomDataFromFile("symptoms.txt");
		List<String> symptoms = symptomReader.getSymptoms();

		//step 2: sort symptoms
		ISymptomSorter symptomSorter = new SortSymptomsFromList();
		TreeSet<String> sortedSymptoms = symptomSorter.sortSymptoms(symptoms);

		//step 3: associate symptoms to their number of occurrences
		ISymptomCounter symptomCounter = new CountSymptomsFromList();
		TreeMap<String, Integer> mappedSymptoms = symptomCounter.countSymptoms(symptoms, sortedSymptoms);

		//step 4: write the analyzed data in result.out
		ISymptomWriter symptomWriter = new WriteSymptomAnalyticsInFile("result.out");
		symptomWriter.writeSymptom(mappedSymptoms);
	}
}