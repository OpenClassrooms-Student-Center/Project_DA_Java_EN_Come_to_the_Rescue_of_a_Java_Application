package com.hemebiotech.analytics;

import java.util.Map;

public interface ISymptomWriter {

    /**
     * Writes the symptoms and their corresponding counts to an output file.
     * The input map associates each symptom (represented by a String) with its count (represented by a Long).
     *
     * @param symptomsCount a map where keys are symptoms (String) and values are counts (Long).
     */
    void writeSymptoms(Map<String, Long> symptomsCount);

}
