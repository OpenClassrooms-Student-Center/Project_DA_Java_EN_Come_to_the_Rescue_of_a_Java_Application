package com.hemebiotech.analytics;

import java.util.TreeMap;

/**
 *
 * Just writes a new list of the data as a map with the symptoms as keys of which the symptoms frequencies
 * are the associated values
 */
public interface ISymptomWriter {
    /**
     * returns a file output with the final form of symptom data : sorted list with each
     * symptom number of occurrences
     */
    void writeSymptom(TreeMap<String, Integer> mappedSymptoms);
}