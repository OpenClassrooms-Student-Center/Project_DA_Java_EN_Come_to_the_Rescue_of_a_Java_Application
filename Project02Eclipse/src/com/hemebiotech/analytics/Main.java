package com.hemebiotech.analytics;

import com.hemebiotech.analytics.counter.AnalyticsCounter;
import com.hemebiotech.analytics.reader.ReadSymptomDataFromFile;
import com.hemebiotech.analytics.writer.WriteSymptomDataOnFile;

import java.util.List;
import java.util.Map;

/**
 * Run the Application
 */
public class Main {
/** The app begin here */
    public static void main(String[] args) {
        // Reading symptoms from file
        ReadSymptomDataFromFile readSymptomDataFromFile = new ReadSymptomDataFromFile("symptoms.txt");
        List<String> listOfSymptoms = readSymptomDataFromFile.getSymptoms();

        // Count symptoms from List
        AnalyticsCounter analyticsCounter = new AnalyticsCounter(listOfSymptoms);
        Map<String, Integer> symptomCounter = analyticsCounter.symptomCounter();

        // write symptom's count on file
        WriteSymptomDataOnFile symptomsCountFile = new WriteSymptomDataOnFile(symptomCounter, "result.out");
        symptomsCountFile.writeSymptoms();

    }

}
