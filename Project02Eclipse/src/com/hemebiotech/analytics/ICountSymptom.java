package com.hemebiotech.analytics;
import java.util.TreeMap;
/** Everything concern count of symptom, we return a TreeMap of result */
public interface ICountSymptom {
    /**
     * @implNote We count how many occur here, and we return the result var
     * @return an TreeMap of result with how many occur by line.
     * */
    TreeMap<String, Integer> countAllSymptoms();
}
