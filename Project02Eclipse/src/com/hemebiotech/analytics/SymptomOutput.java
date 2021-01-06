package com.hemebiotech.analytics;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class SymptomOutput {
    private TreeMap<String, Integer> map = new TreeMap<String, Integer>();

    public SymptomOutput(TreeMap<String, Integer> map){
        this.map = map;
    }

    public void getFileOutput() throws IOException{
        
        try {
            FileWriter writer = new FileWriter ("result.out");
            for(Map.Entry<String,Integer> entry : map.entrySet()){
                String symptom = entry.getKey();
                int occurrences = entry.getValue();
                writer.write(symptom + ": " + occurrences + "\n");
            }
            writer.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}