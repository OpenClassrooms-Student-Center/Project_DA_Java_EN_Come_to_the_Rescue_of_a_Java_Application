package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.TreeMap;

public class AnalyticsCounter {

	private static TreeMap<String, Integer> elementCountMap;
	private static TreeMap<String, Integer> content;

	public static void main(String[] args) throws Exception {

		String filePath = "symptoms.txt";
		ReadSymptomDataFromFile readSymptomDataFromFile = new ReadSymptomDataFromFile(filePath);

		ArrayList<String> listOfLines = new ArrayList<>();
		listOfLines = readSymptomDataFromFile.GetSymptoms();

		MapOccurenceCount mapOccurenceCount = new MapOccurenceCount();
		elementCountMap = mapOccurenceCount.countMapOccurence(listOfLines);

		MapSorting m = new MapSorting();
		MapSorting mapSorting = new MapSorting();

		content = mapSorting.formatted(elementCountMap);

//		// next generate output
//		FileWriter writer = new FileWriter ("result.out");
//		writer.write(String.valueOf(content));
//		writer.close();

		String filename = "result.out";
		WriteSymptomOccurenceInFile writeSymptomOccurenceInFile = new WriteSymptomOccurenceInFile(filename);
		writeSymptomOccurenceInFile.SetSymptoms(content);
	}
}
