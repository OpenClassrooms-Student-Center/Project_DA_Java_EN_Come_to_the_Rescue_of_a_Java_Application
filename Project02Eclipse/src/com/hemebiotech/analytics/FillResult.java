package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

public class FillResult {

    public void write(Map<String, Integer> symptoms) throws IOException {
        Iterator<String> it = symptoms.keySet().iterator();
        FileWriter writer = new FileWriter ("result.out");
        while (it.hasNext()) {
            String symptom = it.next();
            writer.write(symptom + " : " + symptoms.get(symptom) + "\n");
        }
        writer.close();
    }
}
