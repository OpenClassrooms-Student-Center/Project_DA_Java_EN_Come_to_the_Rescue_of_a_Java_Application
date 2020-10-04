package com.hemebiotech.analytics;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class AnalyticsCounter {


    /**
     * @param args [0] contains the path to the symptoms.txt file
     *
     */
    public static void main(String[] args) {

        ISymptomReader readSymptomDataFromFile = new ReadSymptomDataFromFile(args[0]);
        List<String> symptoms = readSymptomDataFromFile.getSymptoms();
        SymptomsOccurrences symptomsOccurrences = new SymptomsOccurrences();
        Map<String, Integer> symptomsOccurrencesMap = symptomsOccurrences.getSymptomsOccurrences(symptoms) ;

        try {
            PrintResultFile printResultFile = new PrintResultFile();
            printResultFile.writeToFile(symptomsOccurrencesMap);
            printResultFile.closeFile();
        }
        catch (IOException ioException){
            ioException.printStackTrace();
        }


    }

}
