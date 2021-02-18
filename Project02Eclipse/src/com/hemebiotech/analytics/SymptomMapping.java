package com.hemebiotech.analytics;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**  
 * 
 * Organizes the symptoms alphabetically and counts the number of occurrences in the file.
 */
<<<<<<< HEAD
public class SymptomMapping implements ISymptomAnalysis{
    private List<String> symptoms = new ArrayList<String>();
=======
public class SymptomMapping {
    private ArrayList<String> symptoms = new ArrayList<String>();
>>>>>>> origin/mapping
    private TreeMap<String, Integer> orderedSymptoms = new TreeMap<String, Integer>();
    /**
     * 
     * @param symptoms an unordered list of all the symptoms appearing in the raw file.
     */
<<<<<<< HEAD
    public SymptomMapping(List<String> symptoms){
=======
    public SymptomMapping(ArrayList<String> symptoms){
>>>>>>> origin/mapping
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
<<<<<<< HEAD
        for(String symptom : symptoms){
            if(orderedSymptoms.containsKey(symptom)){
                int i = orderedSymptoms.get(symptom)+1;
                orderedSymptoms.replace(symptom, i);
            }
            else{
                orderedSymptoms.put(symptom, 1);
=======
        for (int counter=0; counter<symptoms.size(); counter++){
            String readSymptom = symptoms.get(counter);
            //if the symptom that is being read is already present in the file, the number of occurrences gets incremented.
            if (orderedSymptoms.containsKey(readSymptom)){
                int i = orderedSymptoms.get(readSymptom)+1;
                orderedSymptoms.replace(readSymptom, i);
            }
            else {
                orderedSymptoms.put(symptoms.get(counter), 1);
>>>>>>> origin/mapping
            }
        }
        return orderedSymptoms;
    }
}