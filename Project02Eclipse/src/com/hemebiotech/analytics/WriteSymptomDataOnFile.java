package com.hemebiotech.analytics;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class WriteSymptomDataOnFile implements ISymptomWriter{

    private Map<String, Integer> symptomMap;
    private String filepath;

    public WriteSymptomDataOnFile(Map<String, Integer> symptomMap, String filepath) {
        this.symptomMap = symptomMap;
        this.filepath = filepath;
    }

    @Override
    public void writeSymptoms() {
        
        if(filepath != null) {
            try {
                BufferedWriter writer = new BufferedWriter (new FileWriter(filepath, false));

                symptomMap.forEach((symptom, count) -> {
                    try {
                        writer.write(symptom +"="+count);
                        writer.newLine();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });

                writer.close();
				
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
