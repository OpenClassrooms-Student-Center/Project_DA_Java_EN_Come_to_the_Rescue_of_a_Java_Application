package com.hemebiotech.analytics;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Implement the Interface ISymptomWriter
 */
public class WriteSymptomDataToFile implements ISymptomWriter {
    /**
     * Write in a file syptoms and the occurences.
     *
     * @param symptoms K: symptom V: Occurence
     */
    @Override
    public void writeSymptoms(Map<String, Integer> symptoms) {
        List<String> linesToWrite = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : symptoms.entrySet()) {
            linesToWrite.add(entry.getKey() + " : " + entry.getValue());
        }
        try {
            Path outputPath = Paths.get("result.out");
            Files.write(outputPath, linesToWrite);
            System.out.println("Output files is : " + outputPath);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}