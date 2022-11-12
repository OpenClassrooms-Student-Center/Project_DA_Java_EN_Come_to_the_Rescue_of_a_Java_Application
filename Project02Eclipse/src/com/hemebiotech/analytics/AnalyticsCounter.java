package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.List;
import java.util.TreeMap;

public class AnalyticsCounter {

	public static void main(String args[]) {

		Analyse analyse = new Analyse(new ReadSymptomDataFromFile("symptoms.txt"), new CountAndOrderSymptoms(),
				new WriteResultToFile("result.out"));
		List<String> listNotCounted = analyse.getSymptoms();
		TreeMap<String, Integer> mapCountedAndSorted = analyse.treatSymptoms(listNotCounted);
		analyse.writeSymptoms(mapCountedAndSorted);
	}

}
