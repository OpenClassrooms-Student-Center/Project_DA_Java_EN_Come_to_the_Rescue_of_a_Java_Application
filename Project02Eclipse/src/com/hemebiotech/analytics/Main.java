package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

/**
 * Main class to run the symptom analytics application.
 * 
 * This class initializes the reader and writer,
 * executes the analytics process (read, count, sort, write),
 * and delegates the operations to the AnalyticsCounter class.
 */
public class Main {

    /**
     * Entry point of the application.
     * 
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
        // Initialize the reader and writer with file paths
        ISymptomReader reader = new ReadSymptomDataFromFile("symptoms.txt");
        ISymptomWriter writer = new WriteSymptomDataToFile("result.out");

        // Create the counter service by injecting the reader and writer
        AnalyticsCounter counter = new AnalyticsCounter(reader, writer);

        // Step 1: Read all raw symptoms from the file
        List<String> symptoms = counter.getSymptoms();

        // Step 2: Count occurrences of each symptom
        Map<String, Integer> counted = counter.countSymptoms(symptoms);

        // Step 3: Sort symptoms alphabetically
        Map<String, Integer> sorted = counter.sortSymptoms(counted);

        // Step 4: Write sorted symptoms and counts to the output file
        counter.writeSymptoms(sorted);
    }
}