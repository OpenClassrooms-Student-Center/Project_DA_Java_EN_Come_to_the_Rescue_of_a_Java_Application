package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;


/**
 * list all symptoms in a Map (key = symptom, value = number of occurrences)
 *
 */
public class SymptomsOccurrences {
    private final Map<String, Integer> symptomsOccurrencesMap;


    public SymptomsOccurrences() {
        symptomsOccurrencesMap = new TreeMap<>();
    } // Treemap to sort the map alphabetically
    /**
     * @param symptoms listing of all Symptoms obtained from a data source.
     * @return the symptom and its number of occurrences.
     */

    public Map<String, Integer> getSymptomsOccurrences(List<String> symptoms) {

        for (String symptom : symptoms) {
            if (symptomsOccurrencesMap.containsKey(symptom)) {
                symptomsOccurrencesMap.put(symptom, symptomsOccurrencesMap.get(symptom) + 1); // the old value is replaced by the specified value
            } else {
                symptomsOccurrencesMap.put(symptom, 1);
            }
        }
        return symptomsOccurrencesMap;
    }

}
