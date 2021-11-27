package com.hemebiotech.analytics.reader;

import com.hemebiotech.analytics.reader.ISymptomReader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class FileSymptomReader implements ISymptomReader {

    private final String filepath;

    /**
     * @param filepath a full or partial path to file with symptom strings in it, one per line
     */
    public FileSymptomReader(String filepath) {
        this.filepath = filepath;
    }

    @Override
    public List<String> getSymptoms() {
        List<String> symptoms = null;
        try {
            symptoms = Files.readAllLines(Paths.get(this.filepath));
        } catch (IOException e) {
            System.out.println("An error occurred when reading file " + this.filepath);
            System.exit(1);
        }
        return symptoms;
    }
}
