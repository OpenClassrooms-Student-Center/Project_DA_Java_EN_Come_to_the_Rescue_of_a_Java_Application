package com.hemebiotech.analytics;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
/**  
 * 
 * Organizes the symptoms alphabetically and counts the number of occurrences in the file.
 */
public class SymptomMapping implements ISymptomAnalysis{
    private List<String> symptoms = new ArrayList<String>();
    private TreeMap<String, Integer> orderedSymptoms = new TreeMap<String, Integer>();
    /**
     * 
     * @param symptoms an unordered list of all the symptoms appearing in the raw file.
     */
    public SymptomMapping(List<String> symptoms){
        this.symptoms = symptoms;
    }
    /**
     *
     * @return a mapping of all the symptoms in alphabetical order with the number of occurrences.
     */
    @Override
    public TreeMap<String, Integer> analyzeSymptoms(){
        //TreeMap used because it automatically arranges the keys alphabetically.
        
        //going through the full list
        for(String symptom : symptoms){
            if(orderedSymptoms.containsKey(symptom)){
                int i = orderedSymptoms.get(symptom)+1;
                orderedSymptoms.replace(symptom, i);
            }
            else{
                orderedSymptoms.put(symptom, 1);
            }
        }
        return orderedSymptoms;
    }
}