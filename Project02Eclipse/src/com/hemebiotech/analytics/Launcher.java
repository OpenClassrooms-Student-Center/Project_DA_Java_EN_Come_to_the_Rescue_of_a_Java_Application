package com.hemebiotech.analytics;

import java.io.IOException;
import java.util.TreeMap;

/**
 * 
 * @author nico5310
 *
 */
public class Launcher {

	/**
	 * Launcher
	 * 
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {

		/**
		 * Input Source file with access
		 */
		String filePath = "Project02Eclipse/symptoms.txt";

		/**
		 * Output Result file path with access
		 */
		String resultsFilePath = "results.out";

		AnalyticsCounter analyticsCounter = new AnalyticsCounter(filePath, resultsFilePath);

		TreeMap<String, Integer> symptomsOccurences = analyticsCounter.getSymptomsOccurences();

		analyticsCounter.setMapToFile(symptomsOccurences, resultsFilePath);

	}
}