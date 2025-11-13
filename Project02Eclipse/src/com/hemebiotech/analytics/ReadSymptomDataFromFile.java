package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of the ISymptomReader interface.
 * This class reads symptoms from a text file where each line represents one symptom.
 * It returns a list of raw symptom strings, possibly with duplicates.
 * 
 * Example line in file: "headache"
 * 
 * @author Rebecca
 */
public class ReadSymptomDataFromFile implements ISymptomReader {

    private final String filepath;

    /**
     * Constructor that sets the path of the file to be read.
     *
     * @param filepath The path to the symptom text file.
     */
    public ReadSymptomDataFromFile(String filepath) {
        this.filepath = filepath;
    }

    /**
     * Reads symptoms line by line from the text file and returns them in a list.
     *
     * @return A list of symptom strings. Empty if file is not found or unreadable.
     */
    @Override
    public List<String> getSymptoms() {
        List<String> result = new ArrayList<>();

        if (filepath != null) {
            try (BufferedReader reader = new BufferedReader(new FileReader(filepath))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    if (!line.trim().isEmpty()) {
                        result.add(line.trim());
                    }
                }
            } catch (IOException e) {
                System.err.println(" Failed to read file: " + e.getMessage());
            }
        }

        return result;
    }
}
