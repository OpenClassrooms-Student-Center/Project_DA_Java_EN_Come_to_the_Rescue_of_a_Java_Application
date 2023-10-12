package com.hemebiotech.analytics;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Map;

public class WriteSymptomDataToFile implements ISymptomWriter{

    @Override
    public void writeSymptoms(Map<String, Integer> symptoms){
        try {
            FileWriter fileWriter = new FileWriter("result.out");
            BufferedWriter writer = new BufferedWriter(fileWriter);
            for (Map.Entry<String, Integer> entry : symptoms.entrySet()) { //iterating the Map
                writer.write(entry.getKey() + ": " + entry.getValue());
                writer.newLine();
            }
            writer.close();
        }
        catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }

}
