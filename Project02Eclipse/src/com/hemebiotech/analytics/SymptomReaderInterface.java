package com.hemebiotech.analytics;

import java.util.Map;


public interface SymptomReaderInterface {

    /**
     * Creates and saves a file with contents of "mapCounter" variable
     *
     * @param mapCounter a mapList containing contents of the file read
     */
    void saveToFileSymptoms(Map<String, Integer> mapCounter);

}