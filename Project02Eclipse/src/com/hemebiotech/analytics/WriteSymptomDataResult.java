package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class WriteSymptomDataResult implements ISymptomResultWriter{
    private final FileWriter writer;

    /**
     *
     * @throws IOException
     */
    public WriteSymptomDataResult(String filepath) throws IOException {
        this.writer = new FileWriter(filepath);
    }

    /**
     *
     * @param listSymptomsClean
     * @throws IOException
     */
    public void WriteSymptoms(Hashtable<String, Integer> listSymptomsClean ) throws IOException {
        Set<String> keys = listSymptomsClean.keySet();
        Iterator<String> iterator = keys.iterator();
        String str;

        while (iterator.hasNext()) {
           str = iterator.next();
           writer.write(str+" : "+listSymptomsClean.get(str) + "\n" );
        }
        writer.close();
    }


}
