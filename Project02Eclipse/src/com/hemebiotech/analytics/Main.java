package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;
public class Main{
    public static void main(String args[]) throws Exception {

        final String filepath = "symptoms.txt";

        ISymptomReader symptomReader = new ReadSymptomDataFromFile(filepath);
        ISymptomWriter symptomWriter = new WriteSymptomDataToFile();
        AnalyticsCounter analyticsCounter = new AnalyticsCounter(symptomReader, symptomWriter);

        List<String> symptoms = analyticsCounter.getSymptoms();
        Map<String, Integer> symptomCounts = analyticsCounter.countSymptoms(symptoms);
        Map<String, Integer> sortedSymptoms = analyticsCounter.sortSymptoms(symptomCounts);
        analyticsCounter.writeSymptoms(sortedSymptoms);
    }
}