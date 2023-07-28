package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class WriteSymptomDataToFile implements ISymptomWriter{
//    private String symptom;
//    private Integer countOfSymptoms;
//    public WriteSymptomDataToFile(String symptom, Integer countOfSymptoms);{this.symptom=symptom;this.countOfSymptoms}
//    FileWriter writer = new FileWriter ("result.out");
//    writer.write("headache: " + headacheCount + "\n");
//    writer.write("rash: " + rashCount + "\n");
//    writer.write("dialated pupils: " + pupilCount + "\n");
//    writer.close();
    @Override
    public void writeSymptoms(Map<String, Integer> symptoms){
        try {
            for (Map.Entry<String, Integer> entry : symptoms.entrySet()) {
                System.out.println("entry" + entry);
                FileWriter writer = new FileWriter("result.out");
                writer.write("headache: " + headacheCount + "\n");
                writer.write("rash: " + rashCount + "\n");
                writer.write("dialated pupils: " + pupilCount + "\n");
                writer.close();
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}