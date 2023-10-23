package com.hemebiotech.analytics;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Map;
public class WriteSymptomDataToFile implements ISymptomWriter{
    private final String filepath;
    /**
     * @param filepath is the path of the document that will be written
     */
    public WriteSymptomDataToFile(String filepath) {
        this.filepath = filepath;
    }
    @Override
    public void writeSymptoms(Map<String, Integer> symptoms){
        try {
            FileWriter fileWriter = new FileWriter("result.out");
            BufferedWriter writer = new BufferedWriter(fileWriter);
            for (Map.Entry<String, Integer> entry : symptoms.entrySet()) { //iterating the Map
                writer.write(entry.getKey() + ": " + entry.getValue());
                writer.newLine();
                System.out.println(entry.getKey() + ": " + entry.getValue()); //To control if everything works
            }
            writer.close();
        }
        catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }
}
