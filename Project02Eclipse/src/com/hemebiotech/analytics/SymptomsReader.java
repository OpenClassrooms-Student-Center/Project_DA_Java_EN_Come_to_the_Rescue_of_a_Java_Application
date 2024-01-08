package com.hemebiotech.analytics;

import java.nio.file.Files;
import java.nio.file.Path;
import java.io.IOException;
import java.util.List;

public class SymptomsReader implements ISymptomReader {

    private final String filePath;

    public SymptomsReader(String file) {
        this.filePath = file;
    }

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

        // Better to return an empty list, more robust and ensures the calling code can always expect a non-null result
        return result != null ? result : List.of();
    }
}
