package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Fillmap {

    public Map<String, Integer> fill() throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader("symptoms.txt"));
        String line = reader.readLine();
        Map<String, Integer> symptoms = new TreeMap<>();

        while (line != null) {
            if (!symptoms.containsKey(line)) {
                symptoms.put(line, 1);
            } else {
                symptoms.put(line, symptoms.get(line) + 1);
            }
            line = reader.readLine();
        }
        return symptoms;
    }
}
