package com.hemebiotech.analytics.service.impl;

import com.hemebiotech.analytics.service.ISymptomsOperations;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SymptomOperations implements ISymptomsOperations {

    @Override
    public Map<String, Long> symptomsAndCount(List<String> symptoms){
        return symptoms.stream()
                .collect(Collectors.groupingByConcurrent(s -> s, Collectors.counting()))
                // sort map by key
                .entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));
    }

}
