package com.hemebiotech.analytics;
import java.util.Map;
/**
 * Writes a list of symptoms, with the number of occurrences
 * The result will be written in a file named "result.out"
 * The map is not sorted alphabetically in this class
 */
public interface ISymptomWriter {
    /**
     * Writes all the key and value pairs of a map, in a document, line by line
     * @param symptoms is a map, with a Sting as a key (representing the symptoms)
     * and the Integer value is the number of times the symptom has been reported
     */
    void writeSymptoms(Map<String, Integer> symptoms);

}
