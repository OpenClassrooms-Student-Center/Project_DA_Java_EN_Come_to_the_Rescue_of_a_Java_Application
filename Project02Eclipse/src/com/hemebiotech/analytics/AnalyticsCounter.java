package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.util.List;
import java.util.Map;

public class AnalyticsCounter {

    /**
     * @param args [0] contains the path to the symptoms.txt file
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {

        ISymptomReader readSymptomDataFromFile = new ReadSymptomDataFromFile(args[0]);
        List<String> symptoms = readSymptomDataFromFile.GetSymptoms();
        SymptomsOccurrences symptomsOccurrences = new SymptomsOccurrences();
        Map<String, Integer> symptomsOccurrencesMap = symptomsOccurrences.getSymptomsOccurrences(symptoms) ;

        FileWriter writer = new FileWriter("result.out");
        for (Map.Entry<String, Integer> entry : symptomsOccurrencesMap.entrySet()) {
            writer.write(entry.getKey() + ": " + entry.getValue() + "\n");

        }
        writer.close();

    }

}
