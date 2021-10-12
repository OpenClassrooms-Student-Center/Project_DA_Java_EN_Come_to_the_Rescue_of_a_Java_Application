package com.hemebiotech.analytics.analytics.counter;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class SymptomCounter implements ISymptomCounter{

    private List<String> symptoms; // Raw list of all symptoms.
    private final TreeMap<String, Long> sortedSymptoms; // Sorted and counted of all symptoms.

    public SymptomCounter() {
        this.symptoms = new ArrayList<>(); // Initialise symptoms list.
        this.sortedSymptoms = new TreeMap<>(); // Initialise symptoms map.
    }

    @Override
    public void count() {
        this.sortedSymptoms.clear(); // Clear map before.
        this.sortedSymptoms.putAll(this.symptoms.stream().collect(Collectors.groupingBy(e -> e, Collectors.counting()))); // Count and sort symptoms list in TreeMap.
    }

    /**
     *
     * @return a TreeMap with all symptoms sorted and counted.
     */
    public TreeMap<String, Long> getSortedSymptoms() {
        return this.sortedSymptoms;
    }

    /**
     *
     * @param symptoms is raw list with all symptoms.
     */
    public void setSymptoms(List<String> symptoms) {
        this.symptoms = symptoms;
    }

    /**
     *
     * @return get raw symptoms list.
     */
    public List<String> getSymptoms() {
        return this.symptoms;
    }
}
