package com.hemebiotech.analytics;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* class analyze the symptoms
*/

public class AnalyzeSymptoms {

    /**
     * @Function: count
     * @Description: count the number of symptoms
     * @param: List of symptoms
     * @output: HashMap of number of symptoms
     * format : symptom : number
     */
    HashMap<String, Integer> countSymptoms(List<String> listSymptoms) {
        Map<String, Integer> countSymptoms = new HashMap<String, Integer>();
        if (listSymptoms.size() != 0) {
            for (int i = 1; i < listSymptoms.size(); i++) {
                if (countSymptoms.containsKey(listSymptoms.get(i)) == false) {
                    countSymptoms.put(listSymptoms.get(i), 1);
                } else {
                    Integer valSymptom = countSymptoms.get(listSymptoms.get(i));
                    valSymptom++;
                    countSymptoms.replace(listSymptoms.get(i), valSymptom);
                }
            }
        }
        return (HashMap<String, Integer>) countSymptoms;
    }

}
