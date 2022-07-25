package com.hemebiotech.analytics;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class WriteSymptomAnalyticsInFile implements ISymptomWriter {

    private String filepath;
    /**
     *
     * @param filepath a full or partial path to file where final data will be written
     */

    public WriteSymptomAnalyticsInFile(String filepath) {this.filepath = filepath;}

    @Override
    public void writeSymptom(TreeMap<String, Integer> mappedSymptoms) {
        FileWriter fileWriter;
        if (filepath != null) {
            try {
                fileWriter = new FileWriter(filepath);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            BufferedWriter writer = new BufferedWriter(fileWriter);

            try {
                for (Map.Entry<String,Integer> symptom : mappedSymptoms.entrySet()) {
                    writer.write(symptom.getKey());
                    writer.write(" => ");
                    writer.write(String.valueOf(symptom.getValue()));
                    writer.write( '\n');
                }
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}