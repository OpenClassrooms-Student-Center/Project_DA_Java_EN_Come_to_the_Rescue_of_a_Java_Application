package com.hemebiotech.analytics;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class WriteSymptomOnNewFile implements ISymptomWriter {


    private final String file;

    public WriteSymptomOnNewFile(String file) {
        this.file = file;
    }
    @Override
    public void writeSymptoms(Map<String, Integer> mapFromFile) {
        if (file != null) {
            try {
                BufferedWriter writer = new BufferedWriter(new FileWriter(file));

                mapFromFile.forEach((symptom, count) -> {
                    try {
                        writer.write(symptom + "=" + count);
                        writer.newLine();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
                writer.close();
            } catch (IOException ffe) {
                ffe.printStackTrace();
            }
        }
    }


}
