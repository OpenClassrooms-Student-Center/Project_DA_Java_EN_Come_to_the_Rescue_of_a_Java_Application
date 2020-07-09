package com.hemebiotech.analytics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import static java.util.Map.Entry.comparingByKey;
import static java.util.stream.Collectors.toMap;

public class HashMapSorting {
    HashMap<String, Integer> map;
    LinkedHashMap<String, Integer> linkedMap;
    ArrayList<Map.Entry<String, Integer>> arr;

    public HashMap<String, Integer> formatted(HashMap<String, Integer> data) {
        return data .entrySet()
                .stream()
                .sorted(comparingByKey())
                .collect( toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2, LinkedHashMap::new));
    }
}