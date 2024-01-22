package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class SymptomCounter {
    public Map<String, Integer> countSymptoms(List<String> symptoms) {
        Map<String, Integer> symptomsCount = new HashMap <>(); //creation new object the type hashmap  that it'll containts the keys of symptoms & recount exp : anxiety:5 times 
        for (String symptom : symptoms){ // symptoms is the list that receive in parameters
            symptomsCount.put(symptom, symptomsCount.getOrDefault(symptom,0)+1);//getordefault sum the current value to +1
        }
        return symptomsCount; //the hashmap is called symptomscount
    }
}

