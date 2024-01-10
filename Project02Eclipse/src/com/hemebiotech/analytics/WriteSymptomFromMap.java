package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Set;
import java.util.Map.Entry;

public class WriteSymptomFromMap implements ISymptomWriter {

    private HashMap<String, Integer> mapToWrite;

    public WriteSymptomFromMap( HashMap<String, Integer> mapToWrite){
        this.mapToWrite = mapToWrite;
    }
    
    public void WriteSymptoms() throws IOException{
        FileWriter writer = new FileWriter ("Project02Eclipse/result.out");
        for(Entry<String, Integer> toWrite : mapToWrite.entrySet() ){
            try {
                writer.write(toWrite.getKey() + " : " + toWrite.getValue() + "\n");
            } catch (IOException e) {
                e.printStackTrace();
            } // write the actual symptom and this occurrence in the list
    }
    writer.close();
}

}
