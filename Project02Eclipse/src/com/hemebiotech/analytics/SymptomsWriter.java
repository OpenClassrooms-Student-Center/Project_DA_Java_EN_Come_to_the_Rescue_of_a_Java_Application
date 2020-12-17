package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class SymptomsWriter {

    void toFile (String outputPath, Map<String, Integer> symptoms) throws IOException {

        FileWriter writer = new FileWriter(outputPath);

        for (String key : symptoms.keySet()) {
            writer.write(key + ": " + symptoms.get(key));
            writer.write('\n');
        }
        writer.close();
    }
}
