package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class WriteResult {

    public WriteResult(List<String> symptomsListSort) throws IOException{
        String actualSymptoms = symptomsListSort.get(0); //initializes the first symptom
        int count = 0;
        FileWriter writer = new FileWriter ("Project02Eclipse/result.out");
        for(int i=0; i<symptomsListSort.size(); i++){ // browse the list sort
            if (symptomsListSort.get(i).equals(actualSymptoms)){
                count++;
            }
            else{ // all same symptoms follow because the list is sort alphabetically
                writer.write(actualSymptoms + " : " + count + "\n"); // write the actual symptom and this occurrence in the list
                count =1; // first first appearance of the new symptom
                actualSymptoms = symptomsListSort.get(i); // take the next symptom
            }
        }
        writer.write(actualSymptoms + " : " + count); // write the last symptom
		writer.close();
    }
}
