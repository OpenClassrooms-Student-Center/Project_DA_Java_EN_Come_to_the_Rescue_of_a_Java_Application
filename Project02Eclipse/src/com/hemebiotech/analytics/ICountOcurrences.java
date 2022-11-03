package com.hemebiotech.analytics;

import java.util.Map;

/**
 * counts symptom occurrences from a source
 */

public interface ICountOcurrences {
    /**
     *
     * @return a map that contains the name of the symptom as a key and its number of occurrences in value
     */

    Map<String,Integer> countSymptoms();
}
