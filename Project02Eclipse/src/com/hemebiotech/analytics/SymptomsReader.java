package com.hemebiotech.analytics;

import java.nio.file.Files;
import java.nio.file.Path;
import java.io.IOException;
import java.util.List;

public class SymptomsReader implements ISymptomReader {

    private final String filePath;

    /**
     * Constructor of SymptomsReader.
     *
     * @param file pass the file to read the symptoms from.
     */
    public SymptomsReader(String file) {
        this.filePath = file;
    }

    /**
     * Get all the symptoms from a given file.
     *
     * @return a list of String, representing all the symptoms.
     */
    @Override
    public List<String> getSymptoms() {
        List<String> result = null;

        if (filePath != null) {
            try {
                result = Files.readAllLines(Path.of(filePath));
                System.out.println(filePath + " correctly read and closed");
            } catch (IOException e) {
                System.err.println("Exception Error reading the lines:" + e.getMessage());
            }
        } else {
            System.err.println("The given file path is null");
        }

        return result != null ? result : List.of();
    }
}
