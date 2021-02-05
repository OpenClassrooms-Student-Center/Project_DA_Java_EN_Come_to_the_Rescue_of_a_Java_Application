package com.hemebiotech.analytics;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;
/**
 * Creates the file output from the information stocked in the treeMap
 */
public class SymptomOutput implements ISymptomFile{
    private TreeMap<String, Integer> map = new TreeMap<String, Integer>();
    public SymptomOutput(Map<String, Integer> map){
        this.map = (TreeMap<String, Integer>)map;
    }
    /**
     * 
     * @throws IOException
     * @return a result.out file containing all the symptoms and the number of occurrences in alphabetical order.
     */
    @Override
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