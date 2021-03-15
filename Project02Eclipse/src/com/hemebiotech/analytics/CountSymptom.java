package com.hemebiotech.analytics;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.TreeMap;
/**
 * Simple system to count occur of symptomsFile
 *
 */
public class CountSymptom implements ICountSymptom {
    BufferedReader file;
    TreeMap<String, Integer> result;
    /**
     * @param file The file which contain data we'll check
     * @param result the TreeMap we will return which contains the count of symptoms
     */
    public CountSymptom(BufferedReader file, TreeMap<String, Integer> result) {
        this.file = file;
        this.result = result;
    }

    /**
     * @implNote We count how many occur here, and we return the result var
     * @return an TreeMap of result with how many occur by line.
     * */
    @Override
    public TreeMap<String, Integer> countAllSymptoms() {
        try {
            String line = this.file.readLine();

            while(line != null) {
                if (result.get(line) == null) {
                    result.put(line, 1);
                } else {
                    result.put(line, result.get(line) +1);
                }
                line = file.readLine();
            }
            file.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
