package com.hemebiotech.analytics;

import java.io.IOException;
import java.io.FileWriter;
import java.util.Map;

/**
 * Implementation of the ISymptomWriter interface.
 * This class writes symptoms and their occurrence counts to a text file.
 * Each symptom is written on a new line in the format: symptom : count
 
 */
public class WriteSymptomDataToFile implements ISymptomWriter {

    private final String filepath;

    /**
     * Constructor that sets the output file path.
     *
     * @param filepath The path where the symptom data will be written.
     */
    public WriteSymptomDataToFile(String filepath) {
        this.filepath = filepath;
    }

    /**
     * Writes the symptoms and their counts to the specified file.
     *
     * @param symptoms A map of symptom names and their occurrence counts.
     * @throws IllegalArgumentException If the filepath is null or empty.
     */
    @Override
    public void writeSymptoms(Map<String, Integer> symptoms) {
        if (filepath == null || filepath.trim().isEmpty()) {
            throw new IllegalArgumentException("File path cannot be null or empty.");
        }

        try (FileWriter writer = new FileWriter(filepath)) {
            for (Map.Entry<String, Integer> entry : symptoms.entrySet()) {
                writer.write(entry.getKey() + " : " + entry.getValue() + "\n");
            }
            System.out.println(" Output file successfully written: " + filepath);
        } catch (IOException e) {
            System.err.println(" Error writing to output file: " + e.getMessage());
        }
    }
}
