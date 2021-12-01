package com.hemebiotech.analytics;

import com.hemebiotech.analytics.reader.ISymptomReader;
import com.hemebiotech.analytics.writer.ISymptomWriter;

import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

/**
 * Count symptoms
 */
public class AnalyticsCounter {

    private final ISymptomReader reader;
    private final ISymptomWriter writer;

    public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer) {
        this.reader = reader;
        this.writer = writer;
    }

    public void Execute() {
        List<String> symptoms = this.reader.getSymptoms();

        TreeMap<String, Integer> sortedSymptoms = CountSymptoms(symptoms);

        this.writer.export(sortedSymptoms);

        System.exit(0);
    }

    /**
     *
     * @param symptoms list
     * @return void
     */
    private static TreeMap<String, Integer> CountSymptoms(List<String> symptoms) {
        var symptomsMap = new HashMap<String, Integer>();
        for (String symptom : symptoms) {
            if (symptomsMap.containsKey(symptom)) {
                symptomsMap.put(symptom, symptomsMap.get(symptom) + 1);
            } else {
                symptomsMap.put(symptom, 1);
            }
        }
        var sortedSymptoms = new TreeMap<>(symptomsMap);

        sortedSymptoms.forEach((key, value) -> System.out.println(key + "=" + value + ";"));
        return sortedSymptoms;
    }
}
