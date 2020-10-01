package com.hemebiotech.analytics;

import com.hemebiotech.analytics.PrintResult.PrintResultFile;

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

        PrintResultFile printResultFile = new PrintResultFile();
        printResultFile.WriteToFile(symptomsOccurrencesMap);
        printResultFile.CloseFile();

    }

}
