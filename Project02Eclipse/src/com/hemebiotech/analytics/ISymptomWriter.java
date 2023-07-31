package com.hemebiotech.analytics;

import java.util.Map;


public interface ISymptomWriter{
    /**
     * Write in a file syptoms and the occurences.
     *
     * @param symptoms K: symptom V: Occurence
     */
    void writeSymptoms(Map<String, Integer> symptoms);
}
