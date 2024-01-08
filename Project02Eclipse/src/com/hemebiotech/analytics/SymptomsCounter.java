package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SymptomsCounter implements ISymptomCounter {

    private final List<String> symptomsList;

    public SymptomsCounter(List<String> symptomsList) {
        this.symptomsList = symptomsList;
    }

    @Override
    public Map<String, Long> countSymptoms() {
        return symptomsList.stream()
                .collect(Collectors.groupingBy(Function.identity(), TreeMap::new, Collectors.counting()));
    }
}
