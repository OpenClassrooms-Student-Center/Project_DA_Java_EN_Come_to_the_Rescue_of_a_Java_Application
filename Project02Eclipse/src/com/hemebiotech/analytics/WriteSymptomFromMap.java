package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class WriteSymptomFromMap implements ISymptomWriter {

    private HashMap<String, Integer> mapToWrite;
    private List<String> symptomsSort;

    public WriteSymptomFromMap( HashMap<String, Integer> mapToWrite, List<String> symptomsSort){
        this.mapToWrite = mapToWrite;
        this.symptomsSort = symptomsSort;
    }
    
    public void WriteSymptoms() throws IOException{
        FileWriter writer = new FileWriter ("Project02Eclipse/result.out");
         String symptomToWrite = symptomsSort.get(0);
        try {
                writer.write(symptomToWrite + " : " + mapToWrite.get(symptomToWrite) + "\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
        for(int i=0; i<symptomsSort.size(); i++){
            if (!symptomToWrite.equals(symptomsSort.get(i))){
                symptomToWrite = symptomsSort.get(i);
            try {
                writer.write(symptomToWrite + " : " + mapToWrite.get(symptomToWrite) + "\n");
            } catch (IOException e) {
                e.printStackTrace();
            } // write the actual symptom and this occurrence in the list
    }
}
    writer.close();


}
}
