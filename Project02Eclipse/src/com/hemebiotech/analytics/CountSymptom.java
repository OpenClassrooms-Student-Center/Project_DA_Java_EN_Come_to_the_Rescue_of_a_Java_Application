package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.TreeMap;

public class CountSymptom implements ICountSymptom {
    BufferedReader file;
    TreeMap<String, Integer> result;
    /**
     * @param file The file which contain data we'll check
     */
    public CountSymptom(BufferedReader file, TreeMap<String, Integer> result) {
        this.file = file;
        this.result = result;
    }
    @Override
    public TreeMap<String, Integer> count() throws IOException {
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
        return result;
    }
}
