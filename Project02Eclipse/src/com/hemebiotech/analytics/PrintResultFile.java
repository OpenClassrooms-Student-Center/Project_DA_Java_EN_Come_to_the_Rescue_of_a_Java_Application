package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class PrintResultFile {
    private FileWriter fileWriter;


    public PrintResultFile() throws IOException {
        fileWriter = new FileWriter("result.out");
    }

    public void WriteToFile(Map<String, Integer> symptomsOccurrencesMap ) throws IOException {
        for (Map.Entry<String, Integer> entry : symptomsOccurrencesMap.entrySet()) {
            fileWriter.write(entry.getKey() + ": " + entry.getValue() + "\n");

        }

    }

    public void CloseFile() throws IOException {
        fileWriter.close();
    }
}


