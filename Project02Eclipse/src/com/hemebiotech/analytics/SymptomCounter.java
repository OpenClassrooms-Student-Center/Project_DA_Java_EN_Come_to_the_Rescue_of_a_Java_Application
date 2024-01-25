package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;
import java.util.HashMap;


/**
 * The SymptomCounter class is responsible for counting the occurrences of symptoms in a list.
 *
 * Usage:
 * - Create an instance of SymptomCounter.
 * - Call the countSymptoms method, providing a list of symptoms as a parameter.
 * - The method returns a map containing each symptom and its corresponding count.
 *
 * @author Mauricio Lopez
 * @version 1.0
 */
public class SymptomCounter {
    /**
     * Counts the occurrences of symptoms in a list and returns a map.
     *
     * @param symptoms A list of symptoms to be counted.
     * @return A map containing each symptom and its corresponding count.
     */
    public Map<String, Integer> countSymptoms(List<String> symptoms) {
        // Create a new HashMap to store symptom counts.
        Map<String, Integer> symptomsCount = new HashMap <>();
        // Iterate through the list of symptoms. 
        for (String symptom : symptoms){
        // Update the count for the current symptom in the map.
        // If the symptom is not present, use getOrDefault to set its count to 0 and then increment. 
            symptomsCount.put(symptom, symptomsCount.getOrDefault(symptom,0)+1);
        }
        // Return the map containing symptom counts.
        return symptomsCount;
    }
}

