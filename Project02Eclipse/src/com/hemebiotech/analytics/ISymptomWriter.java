package com.hemebiotech.analytics;
import java.util.Map;
public interface ISymptomWriter {

    /**
     * To write the list of symptoms, with the number of occurrences
     * The data will be taken from a HashMap, with a Sting as a key (representing the symptoms)
     * and the Integer value is the number of times the symptom has been reported
     *
     * The result will be written in a file named "result.out"
     * The map is not sorted alphabetically in this class
     */
    public void writeSymptoms(Map<String, Integer> symptoms);

}
