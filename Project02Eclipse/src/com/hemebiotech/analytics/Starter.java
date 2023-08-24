package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

public class Starter {

    public static void startingPoint() {
        String inputFile = ".\\Project02Eclipse\\symptoms.txt";

        ReadSymptomDataFromFile readFile = new ReadSymptomDataFromFile(inputFile);
        List<String> symptomList = readFile.readSymptoms();

        AnalyticsCounter counter = new AnalyticsCounter(symptomList);
        Map<String, Integer> mapCounter = counter.countSymptoms(symptomList);

        counter.printToScreenSymptoms(mapCounter);
        counter.saveToFileSymptoms(mapCounter);
    }
}
