package com.hemebiotech.analytics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class HashMapSorting {
    HashMap<String, Integer> map;
    LinkedHashMap<String, Integer> linkedMap;
    ArrayList<Map.Entry<String, Integer>> arr;

    public void sort() {
        for(Map.Entry<String, Integer> e: map.entrySet()) {
            arr.add(e);
        }

        Comparator<Map.Entry<String, Integer>> valueComparator = new Comparator<Map.Entry<String, Integer>>() {

            @Override
            public int compare(Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2) {
                String v1 = e1.getKey();
                String v2 = e2.getKey();
                return v1.compareTo(v2);
            }
        };

        Collections.sort(arr, valueComparator);

        for(Map.Entry<String, Integer> e: arr) {
            linkedMap.put(e.getKey(), e.getValue());
        }
        System.out.println(linkedMap);
    }

    HashMapSorting(){
        map = new HashMap<>();

        map.put("z", 10);
        map.put("g", 30);
        map.put("c", 20);
        map.put("a", 5);
        map.put("b", 40);

        linkedMap = new LinkedHashMap<>();
        arr = new ArrayList<>();
    }

    public static void main(String[] args) {
        HashMapSorting m = new HashMapSorting();
        m.sort();
    }
}