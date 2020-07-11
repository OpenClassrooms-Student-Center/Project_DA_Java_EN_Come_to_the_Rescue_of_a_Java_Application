package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class WriteSymptomOccurenceInFile implements ISymptomWriter {

    private String filename;
    
    public WriteSymptomOccurenceInFile(String filename) {
        this.filename = filename;
    }

    @Override
    public void SetSymptoms(TreeMap<String, Integer> data) {

        try {
            FileWriter writer = new FileWriter(filename);
            Set s = data.entrySet();
            Iterator it = s.iterator();
            while ( it.hasNext() ) {
                Map.Entry entry = (Map.Entry) it.next();
                String key = (String) entry.getKey();
                int value = (Integer) entry.getValue();
                System.out.println(key + " => " + value);
                writer.write(key + " => " + value + "\n");
            }//while
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
