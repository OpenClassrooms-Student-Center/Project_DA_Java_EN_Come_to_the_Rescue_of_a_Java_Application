package com.hemebiotech.analytics;
import java.util.Map;
import java.util.TreeMap;
/**
 * The SortSymptoms class is responsible for sorting a map of symptoms alphabetically.
 *
 * Usage:
 * - Create an instance of SortSymptoms.
 * - Call the sortSymptoms method, providing a map of symptoms as a parameter.
 * - The method returns a TreeMap containing the sorted symptoms.
 *
 * @author Mauricio Lopez
 * @version 1.0
 */

public class SortSymptoms {

    /**
     * Sorts a map of symptoms alphabetically and returns a TreeMap.
     *
     * @param symptoms A map of symptoms to be sorted.
     * @return A TreeMap containing the sorted symptoms.
     */
    public Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms) {
        // Create a new TreeMap with the contents of the input map.
        // TreeMap automatically sorts the entries based on their natural order (lexicographical order for strings).
        return new TreeMap<>(symptoms);

}
}
