package com.hemebiotech.analytics;

import java.io.IOException;
import java.util.TreeMap;

public class Launcher {

	public static void main(String[] args) throws IOException {
		String filePath = "Project02Eclipse/symptoms.txt";
		String resultsFilePath = "results.out";

		AnalyticsCounter analyticsCounter = new AnalyticsCounter(filePath, resultsFilePath);

		TreeMap<String, Integer> symptomsOccurences = analyticsCounter.getSymptomsOccurences();

		System.out.println(symptomsOccurences);

		analyticsCounter.setMapToFile(symptomsOccurences, resultsFilePath);
	}
}