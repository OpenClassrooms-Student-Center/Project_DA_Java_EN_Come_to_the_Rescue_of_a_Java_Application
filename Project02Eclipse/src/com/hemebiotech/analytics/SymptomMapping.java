package com.hemebiotech.analytics;

import java.util.ArrayList;
import java.util.TreeMap;

public class SymptomMapping {
    
    private ArrayList<String> symptoms = new ArrayList<String>();
    private TreeMap<String, Integer> orderedSymptoms = new TreeMap<String, Integer>();

    public SymptomMapping(ArrayList<String> symptoms){

        this.symptoms = symptoms;

    }

    public TreeMap<String, Integer> analyzeSymptoms(){

        for (int counter=0; counter<symptoms.size(); counter++){

            String readSymptom = symptoms.get(counter);

            if (orderedSymptoms.containsKey(readSymptom)){

                int i = orderedSymptoms.get(readSymptom)+1;
                orderedSymptoms.replace(readSymptom, i);

            }
            else {

                orderedSymptoms.put(symptoms.get(counter), 1);

            }
        }

        return orderedSymptoms;
    }
}
