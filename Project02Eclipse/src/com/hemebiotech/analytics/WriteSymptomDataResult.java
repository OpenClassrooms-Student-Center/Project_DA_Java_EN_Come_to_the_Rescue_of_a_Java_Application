package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class WriteSymptomDataResult implements ISymptomResultWriter{
    private final FileWriter writer = new FileWriter("result.out");

    /**
     *
     * @throws IOException
     */
    public WriteSymptomDataResult() throws IOException {}

    /**
     *
     * @param listSymptomsClean
     * @throws IOException
     */
    public void WriteSymptoms(Hashtable<String, Integer> listSymptomsClean ) throws IOException {
        Set<String> keys = listSymptomsClean.keySet();
        Iterator<String> itr = keys.iterator();
        String str;

        while (itr.hasNext()) {
           str = itr.next();
           writer.write(str+" : "+listSymptomsClean.get(str) + "\n" );
        }
        writer.close();
    }


}
