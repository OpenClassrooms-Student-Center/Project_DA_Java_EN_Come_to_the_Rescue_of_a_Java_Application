package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Set;

public class WriteSymptomFromMap implements ISymptomWriter {

    private HashMap<String, Integer> mapToWrite;

    public WriteSymptomFromMap( HashMap<String, Integer> mapToWrite){
        this.mapToWrite = mapToWrite;
    }
    
    public void WriteSymptoms(){
        try (FileWriter writer = new FileWriter ("Project02Eclipse/result.out")) {
            Set<String> symptoms = mapToWrite.keySet();
            for(int i=0; i<symptoms.size(); i++){
                try {
                    writer.write(symptoms.iterator() + " : " + mapToWrite.get(symptoms.iterator()) + "\n");
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } // write the actual symptom and this occurrence in the list
                symptoms.iterator().next();
   }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
}

}
