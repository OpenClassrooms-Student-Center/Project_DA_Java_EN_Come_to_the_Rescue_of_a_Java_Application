package com.hemebiotech.analytics;
import java.util.TreeMap;
import java.io.IOException;
import java.io.FileWriter;
public class WriteSymptom implements IWriteSymptom {
    private final TreeMap<String, Integer> result;

    public WriteSymptom(TreeMap<String, Integer> result) {
        this.result = result;
    }

    /**
     * adding results into a file and write it.
     */
    public void write() {
        try {
            FileWriter writer = new FileWriter("result.out");
            writer.write(String.valueOf(this.result));
            writer.close();
            System.out.println("Results exported !");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
