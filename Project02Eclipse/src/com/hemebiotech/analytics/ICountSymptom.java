package com.hemebiotech.analytics;

import java.io.IOException;
import java.util.TreeMap;

public interface ICountSymptom {
    /**
     *
     * @return an TreeMap of result with how many occur by line.
     * @throws IOException throw an error
     */
    TreeMap<String, Integer> count() throws IOException;
}
