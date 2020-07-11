package com.hemebiotech.analytics;

import com.hemebiotech.helpers.interfaceHelpers.ISymptomWriter;

import java.util.List;
import java.util.Map;

public class AnalyticsCounter {

	private static Map<String, Integer> elementCountMap;

	public static void main(String[] args) throws Exception {

		String filePath = "symptoms.txt";
		ReadSymptomDataFromFile readSymptomDataFromFile = new ReadSymptomDataFromFile(filePath);
		List<String> listOfLines = readSymptomDataFromFile.GetSymptoms();

		MapOccurenceCount mapOccurenceCount = new MapOccurenceCount();
		elementCountMap = mapOccurenceCount.countMapOccurence(listOfLines);

		String filename = "result.out";
		ISymptomWriter writeSymptomOccurenceInFile = new WriteSymptomOccurenceInFile(filename);
		writeSymptomOccurenceInFile.writeSymptoms(elementCountMap);
	}
}
