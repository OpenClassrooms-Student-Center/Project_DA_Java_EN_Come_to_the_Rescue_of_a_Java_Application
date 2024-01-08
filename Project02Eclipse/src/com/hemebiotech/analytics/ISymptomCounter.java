package com.hemebiotech.analytics;

import java.util.Map;

public interface ISymptomCounter {

    /**
     * Counts the occurrences of symptoms and returns a map associating each symptom (String) with its count (Long).
     *
     * @return a map where keys are symptoms (String) and values are counts (Long).
     */
    Map<String, Long> countSymptoms();

}
