package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class SymptomsOccurrences {
    private Map<String, Integer> symptomsOccurrencesMap;

    public SymptomsOccurrences()
    {
        symptomsOccurrencesMap = new TreeMap<>();
    }

    public Map<String, Integer> getSymptomsOccurrences(List<String> symptoms)
    {
        for (String symptom : symptoms) {
            if (symptomsOccurrencesMap.containsKey(symptom)) {
                symptomsOccurrencesMap.put(symptom, symptomsOccurrencesMap.get(symptom) + 1);
            } else {
                symptomsOccurrencesMap.put(symptom, 1);
            }
        }
        return symptomsOccurrencesMap;
    }

}
