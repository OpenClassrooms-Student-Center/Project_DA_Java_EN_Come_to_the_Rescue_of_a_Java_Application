package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class CountSymptoms implements ICountOcurrences {

    private List<String> symptomsList;

    public CountSymptoms(List<String> symptomsList) {
        this.symptomsList = symptomsList;
    }

    @Override
    public Map<String, Integer> countSymptoms() {
        /**
         * @return a map that contains the name of the symptom in key and
         * its number of occurrences by value in alphabetical order
         */
        Map<String,Integer> symptomsOrderedMap = new TreeMap<>();
        for (String symptom : symptomsList){
            if (!symptomsOrderedMap.containsKey(symptom)){
                symptomsOrderedMap.put(symptom,1);
            } else {
                symptomsOrderedMap.put(symptom,symptomsOrderedMap.get(symptom)+1);
            }
        }
        return symptomsOrderedMap;
    }
}
