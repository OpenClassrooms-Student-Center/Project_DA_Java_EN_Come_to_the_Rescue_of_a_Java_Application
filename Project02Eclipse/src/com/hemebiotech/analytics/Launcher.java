package com.hemebiotech.analytics;

import java.io.IOException;

public class Launcher {

	public static void main(String[] args) throws IOException {
		String filePath = "Project02Eclipse/symptoms.txt";
		String resultsFilePath = "results.out";

		AnalyticsCounter analyticsCounter = new AnalyticsCounter(filePath);

		System.out.println(analyticsCounter.getSymptomsOccurences());
	}
}