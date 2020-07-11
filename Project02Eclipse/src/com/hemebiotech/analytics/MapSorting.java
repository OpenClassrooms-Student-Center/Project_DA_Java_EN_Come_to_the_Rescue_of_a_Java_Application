package com.hemebiotech.analytics;

import java.util.*;

public class MapSorting {

    public TreeMap<String, Integer> formatted(TreeMap<String, Integer> data) {
        TreeMap<String, Integer> response = new TreeMap<>();
        Set s = data.entrySet();
        Iterator it = s.iterator();
        while ( it.hasNext() ) {
            Map.Entry entry = (Map.Entry) it.next();
            String key = (String) entry.getKey();
            int value = (Integer) entry.getValue();
            response.put(key, value);
        }//while

        return response;
    }
}