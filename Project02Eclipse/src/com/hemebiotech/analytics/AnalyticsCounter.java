package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;

public class AnalyticsCounter {

	private static HashMap<String, Integer> elementCountMap;
	private static HashMap<String, Integer> content;

	public static void main(String[] args) throws Exception {

		String filePath = "symptoms.txt";
		ReadSymptomDataFromFile readSymptomDataFromFile = new ReadSymptomDataFromFile(filePath);

		ArrayList<String> listOfLines = new ArrayList<>();
		listOfLines = readSymptomDataFromFile.GetSymptoms();

		ArrayElementCount arrayElementCount = new ArrayElementCount();
		elementCountMap = arrayElementCount.arrayElementCount(listOfLines);

		HashMapSorting m = new HashMapSorting();
		HashMapSorting hashMapSorting = new HashMapSorting();

		content = hashMapSorting.formatted(elementCountMap);

		// next generate output
		FileWriter writer = new FileWriter ("result.out");
		writer.write(String.valueOf(content));
		writer.close();
	}
}
