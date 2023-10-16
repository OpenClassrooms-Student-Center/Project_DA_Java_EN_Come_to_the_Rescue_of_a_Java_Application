package com.hemebiotech.analytics;
import java.util.List;
import java.util.Map;
/**
 * Executes all the methods
 */
public class Main {
    /**
     * Executes all the methods
     */
    public static void main(String[] args){
        ISymptomReader reader = new ReadSymptomDataFromFile("symptoms.txt");
        ISymptomWriter writer = new WriteSymptomDataToFile("result.out");
        AnalyticsCounter counter = new AnalyticsCounter(reader, writer);
        List<String> symptomList = counter.getSymptoms();
        Map<String, Integer> symptomMap = AnalyticsCounter.countSymptoms(symptomList);
        Map<String, Integer> sortedMap = AnalyticsCounter.sortSymptoms(symptomMap);
        AnalyticsCounter.writeSymptoms(sortedMap);
    }
}
