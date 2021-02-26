package com.hemebiotech.analytics;

import java.io.File;
import java.util.List;

public class AnalyticsCounter {

	public static void main(String args[]) throws Exception {

		String symptomsFile = new File("Project02Eclipse/symptoms.txt").getCanonicalPath();
		ReadSymptomDataFromFile reader = new ReadSymptomDataFromFile(symptomsFile);
		List<String> symptomList = reader.GetSymptoms();
		CountFreq counter = new CountFreq();
		List<String> symptomCount;
		symptomCount = counter.CountFrequency(symptomList);
		AlphabeticalOrder inOrderAlphabetic = new AlphabeticalOrder();
		List<String> listInOrder = inOrderAlphabetic.AlphabeticalOrder(symptomCount);
		WriteInFile writer = new WriteInFile(listInOrder);
	}
}
