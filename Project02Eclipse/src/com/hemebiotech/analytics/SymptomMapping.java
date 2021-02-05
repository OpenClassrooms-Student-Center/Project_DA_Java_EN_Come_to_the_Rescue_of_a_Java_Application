package com.hemebiotech.analytics;
import java.util.ArrayList;
import java.util.TreeMap;
/**  
 * 
 * Organizes the symptoms alphabetically and counts the number of occurrences in the file.
 */
public class SymptomMapping {
    private ArrayList<String> symptoms = new ArrayList<String>();
    private TreeMap<String, Integer> orderedSymptoms = new TreeMap<String, Integer>();
    /**
     * 
     * @param symptoms an unordered list of all the symptoms appearing in the raw file.
     */
    public SymptomMapping(ArrayList<String> symptoms){
        this.symptoms = symptoms;
    }
    /**
     *
     * @return a mapping of all the symptoms in alphabetical order with the number of occurrences.
     */
    public TreeMap<String, Integer> analyzeSymptoms(){
        //TreeMap used because it automatically arranges the keys alphabetically.
        //going through the full list
        for (int counter=0; counter<symptoms.size(); counter++){
            String readSymptom = symptoms.get(counter);
            //if the symptom that is being read is already present in the file, the number of occurrences gets incremented.
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
