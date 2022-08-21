package com.hemebiotech.analytics.writer;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class Writer implements ISymptomsCountWriter {

    private final String filepath;

    public Writer(String filepath) {
        this.filepath = filepath;
    }

    @Override
    public void writeSymptoms(Map<String, Long> symptomsAndCount) {
        if (filepath != null) {
            try {
                // create output file
                FileWriter writer = new FileWriter(filepath);

                // write symptom and count them
                symptomsAndCount.forEach((s, value) -> writeInFile(writer, s, value));
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void writeInFile(FileWriter writer, String s, Long value) {
        try {
            writer.write(s + ": " + value + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
