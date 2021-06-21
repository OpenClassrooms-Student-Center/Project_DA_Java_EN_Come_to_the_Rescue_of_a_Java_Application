package com.hemebiotech.analytics;


import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.*;

/**
 * Occurrences counting,sorting,and saving into file part
 */
public class AnalyticsCounter {

    private static final String filePathReader = "Project02Eclipse\\symptoms.txt";
    private static final String filePathWriter = "Project02Eclipse\\results.out.txt";

    /**
     * Implementing a main method in order to execute the program
     *
     * @param args Are params that can be provided in our method(not provided in our case)
     */
    public static void main(String args[]) {
        AnalyticsCounter analyticsCounter = new AnalyticsCounter();
        ISymptomReader reader = new ReadSymptomDataFromFile(filePathReader);
        List<String> symptoms = reader.getSymptoms();
        Map<String, Integer> mapOccurrences = analyticsCounter.counting(symptoms);
        analyticsCounter.saving(mapOccurrences);
    }

    /**
     * This method is charged to count the symptoms occurrences
     *
     * @param symptoms All symptoms that we can read from file
     * @return Return symptoms with their numbers of occurrences
     */
    private Map<String, Integer> counting(List<String> symptoms) {
        System.out.println("**************************************** Start counting from List ***********************************************");
        Map<String, Integer> mapOccurrences = new TreeMap<>();
        for (String symptom : symptoms) {
            mapOccurrences.put(symptom, mapOccurrences.getOrDefault(symptom, 0) + 1);
        }
        System.out.println("**************************************** End counting from List ***********************************************");
        return mapOccurrences;

    }

    /**
     * Method that is responsible for writing the symptoms with their number of occurrences into file
     *
     * @param mapOccurrences All symptoms and their number of occurrences
     */
    private void saving(Map<String, Integer> mapOccurrences) {
        System.out.println("**************************************** Start saving into file ***********************************************");
        //BufferedWriter in order to  write the occurrences coming  from memory to results.out.txt file
        try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream(filePathWriter), "utf-8"))) {

            for (Map.Entry<String, Integer> symptomsOccurrence : mapOccurrences.entrySet()) {
                writer.write(symptomsOccurrence.getKey() + ":" + symptomsOccurrence.getValue());
                writer.newLine();
            }

        } catch (IOException e) {
            System.out.println("Error occurring during saving into file, please contact your administrator, for more details : " + e.getMessage());
        }
        System.out.println("**************************************** End saving into file ***********************************************");
    }
}
