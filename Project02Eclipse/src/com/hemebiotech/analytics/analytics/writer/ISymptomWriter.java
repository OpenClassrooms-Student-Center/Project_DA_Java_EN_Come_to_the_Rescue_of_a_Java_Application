package com.hemebiotech.analytics.analytics.writer;

import java.util.TreeMap;

public interface ISymptomWriter {

    /**
     * Write "result.out" file from param
     * @param symptomsMap is the map of all symptoms sorted
     */
    void write(TreeMap<String, Long> symptomsMap);
}
