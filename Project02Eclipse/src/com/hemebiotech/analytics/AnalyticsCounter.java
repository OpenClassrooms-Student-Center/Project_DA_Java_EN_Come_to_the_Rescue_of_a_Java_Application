package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class AnalyticsCounter {
    public static void main(String[] args) throws Exception {

        ReadSymptomDataFromFile reader = new ReadSymptomDataFromFile("symptoms.txt");

        List<String> myListOfSymptoms = reader.GetSymptoms();

        Map<String, Integer> mapSymptomWithNumberOccurence = new TreeMap<>();

        for (String symptom : myListOfSymptoms) {
            if (mapSymptomWithNumberOccurence.containsKey(symptom)) {
                // on incrémente la valeur existante
                int countOccurence = mapSymptomWithNumberOccurence.get(symptom);
                countOccurence++;
                mapSymptomWithNumberOccurence.replace(symptom, countOccurence);
            } else {
                mapSymptomWithNumberOccurence.put(symptom, 1);
            }
        }

        for (String symptom : mapSymptomWithNumberOccurence.keySet()) {
            System.out.println(symptom + ":" + mapSymptomWithNumberOccurence.get(symptom));
        }

    }
}
