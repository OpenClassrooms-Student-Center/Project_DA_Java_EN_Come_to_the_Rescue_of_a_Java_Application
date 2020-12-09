package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.util.Map;
import java.util.TreeMap;

import static com.hemebiotech.analytics.CountSymptoms.CountLines;

public class AnalyticsCounter {

    public static void main(String[] args) throws Exception {

        Map<String, Integer> symptoms = new TreeMap<>();
        CountLines("Project02Eclipse/symptoms.txt", symptoms);
        System.out.println(symptoms);

        //         write output
        FileWriter writer = new FileWriter("result.out");
        for (String key : symptoms.keySet()) {
            writer.write(key + ": " + symptoms.get(key));
            writer.write('\n');
        }
        writer.close();
    }
}
