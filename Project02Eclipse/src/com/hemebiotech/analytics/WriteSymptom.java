package com.hemebiotech.analytics;
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
            for (int i =0; i < this.result.size(); i++) {
                //we change treeMap in array to get value from an index
                writer.write(this.result.keySet().toArray()[i] +" : " + this.result.get(this.result.keySet().toArray()[i]) + "\n");
            }
            writer.close();
            System.out.println("Results exported !");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
