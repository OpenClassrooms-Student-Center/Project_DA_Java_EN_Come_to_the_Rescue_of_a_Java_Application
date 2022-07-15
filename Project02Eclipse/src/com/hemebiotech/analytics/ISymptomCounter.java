package com.hemebiotech.analytics;

import java.util.List;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * This allows us to count each symptom frequency and shall return a Map using the sortedSymptoms
 * set entries as key, and their number of occurrences as values.
 */
public interface ISymptomCounter {
    /**
     * @param symptoms a raw listing allowing duplicates
     * @param sortedSymptoms an ordered listing without duplicates
     * @return a map <symptom, number of symptom occurrences>
     */
    TreeMap<String, Integer> countSymptoms (List<String> symptoms, TreeSet<String> sortedSymptoms);
}