package com.hemebiotech.analytics;

import java.util.*;

public class CountSymptomsFromList implements ISymptomCounter {
    /**
     * @param symptoms a raw listing from the symptom data file
     * @param sortedSymptoms an ordered and duplicates-free listing of the collected symptoms
     * @return mapped symptoms with their frequencies
     */
    @Override
    public TreeMap<String, Integer> countSymptoms(List<String> symptoms, TreeSet<String> sortedSymptoms) {
        TreeMap<String,Integer> result = new TreeMap<>();
        for (String symptom : sortedSymptoms) result.put(symptom, Collections.frequency(symptoms, symptom));
        return result;
    }
}