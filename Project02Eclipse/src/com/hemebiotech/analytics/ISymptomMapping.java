package com.hemebiotech.analytics;

import java.util.Map;

/**
 * Interface counting the symptoms
 */

public interface ISymptomMapping {

    /**
     * Method counting the symptoms
     * @return a map with each symptom an its occurrences
     */

    public Map<String, Integer> analyzeSymptoms();
    
}
