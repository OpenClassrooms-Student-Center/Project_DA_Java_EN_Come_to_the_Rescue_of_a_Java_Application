package com.hemebiotech.analytics.utils;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Utils {

    public static Map<String, Long> symptomsAndCount(List<String> symptoms){
        return symptoms.stream()
                .collect(Collectors.groupingByConcurrent(s -> s, Collectors.counting()))
                // sort map by key
                .entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));
    }

}
