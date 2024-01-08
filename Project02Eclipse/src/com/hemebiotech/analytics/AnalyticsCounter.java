package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

public class AnalyticsCounter {

    public static void main(String[] args) {
		//Read all symptoms and store them in a list
        String fileToRead = "Project02Eclipse/symptoms.txt";
        SymptomsReader symptomsReader = new SymptomsReader(fileToRead);
		List<String> symptomsList = symptomsReader.getSymptoms();

		//Count the occurrences of symptoms and sort the list
		SymptomsCounter listerCounter = new SymptomsCounter(symptomsList);
		Map<String, Long> listedCountedList = listerCounter.countSymptoms();

		//Write the Map of symptoms/count to the file
        String fileToWrite = "result.out";
        SymptomsWriter symptomsWriter = new SymptomsWriter(fileToWrite);
		symptomsWriter.writeSymptoms(listedCountedList);
	}

}
