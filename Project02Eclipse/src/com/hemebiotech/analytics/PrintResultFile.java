package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
/**
 *
 * write the list of symptoms and their number of occurrences in the result.out
 */
public class PrintResultFile {
    private FileWriter fileWriter;

    /**
     * @throws IOException exception handling
     *
     */
    public PrintResultFile() throws IOException {
        fileWriter = new FileWriter("result.out");
    }
    /**
     * @param symptomsOccurrencesMap  key = symptom, value = number of occurrences
     * 
     */
    public void writeToFile(Map<String, Integer> symptomsOccurrencesMap ) throws IOException {
        for (Map.Entry<String, Integer> entry : symptomsOccurrencesMap.entrySet()) {
            fileWriter.write(entry.getKey() + ": " + entry.getValue() + "\n");
        }
    }
    /**
     * Closes the stream, flushing it first.
     */
    public void closeFile() throws IOException {
        fileWriter.close();
    }
}


