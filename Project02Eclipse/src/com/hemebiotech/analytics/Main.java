package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

public class Main{
    /**
     * Main function of the app
     * @param args
     * @throws Exception
     */
    public static void main(String args[]) throws Exception {
        final String FILEPATH = "symptoms.txt";

        ISymptomReader symptomReader = new ReadSymptomDataFromFile(FILEPATH);
        ISymptomWriter symptomWriter = new WriteSymptomDataToFile();
        AnalyticsCounter analyticsCounter = new AnalyticsCounter(symptomReader, symptomWriter);

        List<String> symptoms = analyticsCounter.getSymptoms();
        Map<String, Integer> symptomCounts = analyticsCounter.countSymptoms(symptoms);
        Map<String, Integer> sortedSymptoms = analyticsCounter.sortSymptoms(symptomCounts);
        analyticsCounter.writeSymptoms(sortedSymptoms);
    }
}