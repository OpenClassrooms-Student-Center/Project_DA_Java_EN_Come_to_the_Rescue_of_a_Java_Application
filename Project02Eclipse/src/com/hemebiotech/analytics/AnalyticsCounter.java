package com.hemebiotech.analytics;

import com.hemebiotech.helpers.interfaceHelpers.ISymptomWriter;

import java.util.List;
import java.util.Map;

public class AnalyticsCounter {

	private static Map<String, Integer> elementCountMap;
	private String filePath;
	private String filename;

	public AnalyticsCounter(String filePath, String filename) {
		this.filePath = filePath;
		this.filename = filename;
	}

	public void readAndSaveOccurenceSymptoms() {

		ReadSymptomDataFromFile readSymptomDataFromFile = new ReadSymptomDataFromFile(this.filePath);
		List<String> listOfLines = readSymptomDataFromFile.GetSymptoms();

		MapOccurenceCount mapOccurenceCount = new MapOccurenceCount();
		elementCountMap = mapOccurenceCount.countMapOccurence(listOfLines);

		ISymptomWriter writeSymptomOccurenceInFile = new WriteSymptomOccurenceInFile(this.filename);
		writeSymptomOccurenceInFile.writeSymptoms(elementCountMap);
	}
}
