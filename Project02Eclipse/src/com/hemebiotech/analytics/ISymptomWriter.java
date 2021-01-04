package com.hemebiotech.analytics;

import java.util.TreeMap;

/**
 * Anything that will read symptom data from TreeMap of String and Integer
 * and write it in a file, one per line, with the number of occurrence of each symptom.
 *
 *
 *
 */
public interface ISymptomWriter {

    void writeInFile(TreeMap<String,Integer> symptoms);

}
