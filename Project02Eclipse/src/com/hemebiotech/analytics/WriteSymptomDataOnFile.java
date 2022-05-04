package com.hemebiotech.analytics;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Map;

public class WriteSymptomDataOnFile implements ISymptomWriter{

    private String filepath;
    private Map<String, Integer> symptomMap;

    public WriteSymptomDataOnFile(String filepath, Map<String, Integer> symptomMap) {
        this.filepath = filepath;
        this.symptomMap = symptomMap;
    }

    @Override
    public void writeSymptoms() {
        
        if(filepath != null) {
            try {
                BufferedWriter writer = new BufferedWriter (new FileWriter(filepath, false));
				
            } catch (Exception e) {
                //TODO: handle exception
            }
        }
    }

}
