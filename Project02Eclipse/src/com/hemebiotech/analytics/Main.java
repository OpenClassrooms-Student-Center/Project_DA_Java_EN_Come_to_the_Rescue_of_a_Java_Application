package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

public class Main {

	public static String filepathIn = ".\\Project02Eclipse\\symptoms.txt";

	public static void main(String args[]) {

		ReadSymptomDataFromFile reader = new ReadSymptomDataFromFile(filepathIn);
		WriteSymptomDataToFile writer = new WriteSymptomDataToFile();
		AnalyticsCounter analyticsCounter = new AnalyticsCounter(reader, writer);

		List<String> listSymptoms = reader.getSymptoms();

		Map<String, Integer> countedSymptoms = analyticsCounter.countSymptoms(listSymptoms);

		Map<String, Integer> sortedSymptoms = analyticsCounter.sortSymptoms(countedSymptoms);

		writer.writeSymptoms(sortedSymptoms);

	}

}
