package com.hemebiotech.analytics;
import java.util.Map;
import java.util.TreeMap;
import java.io.IOException;
import java.io.FileWriter;
/**
 * Simple system to export result
 *
 */
public class WriteSymptom implements IWriteSymptom {
    private final TreeMap<String, Integer> result;
    /**
     * @param result : We take it to take it size and use for with it to write symptoms
     * */
    public WriteSymptom(TreeMap<String, Integer> result) {
        this.result = result;
    }
    /**
     * @implNote  adding results into a file and write it.
     * return void
     */
    public void writeSymptomsInFile() {
        try {
            FileWriter writer = new FileWriter("result.out");
            for (Map.Entry<String, Integer> entry : this.result.entrySet()) {
                String key = entry.getKey();
                Integer value = entry.getValue();
                //we change treeMap in array to get value from an index
                writer.write(key +" : " + value + "\n");
            }
            writer.close();
            System.out.println("Results exported !");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
