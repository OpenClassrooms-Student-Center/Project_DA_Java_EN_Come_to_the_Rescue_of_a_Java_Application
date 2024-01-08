package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.Objects;

public class SymptomsWriter implements ISymptomWriter {

    private final String filePath;

    public SymptomsWriter(String file) {
        this.filePath = file;
    }

    /**
     * writeSymptoms writes symptoms and associated counts to a document based on the key/values in the map
     *
     * @param symptomsCount the HashMap with key/value, a pair of symptoms name/counter
     */
    @Override
    public void writeSymptoms(Map<String, Integer> symptomsCount) {
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(filePath);
            for (Map.Entry<String, Integer> entry : symptomsCount.entrySet()) {
                String newSymptom = entry.getKey() + " = " + entry.getValue() + "\n";
                fileWriter.write(newSymptom);
            }
        } catch (IOException e) {
            System.err.println("Error writing the file :" + e.getMessage());
        } finally {
            try {
                Objects.requireNonNull(fileWriter).close();
                System.out.println("Writer correctly closed");
            } catch (IOException e) {
                System.err.println("Error closing the writer: " + e);
            }
        }
    }
}
