package com.hemebiotech.analytics;

import java.util.List;

/**
 * Interface for reading symptoms from a data source such as a file, database, or API.
 * Implementations should return raw symptom data without sorting or filtering.
 * 
 * @author Rebecca Guimaraes
 */
public interface ISymptomReader {

    /**
     * Reads symptoms from a data source.
     *
     * @return A list of symptoms, possibly containing duplicates. The list may be empty if no data is found.
     */
    List<String> getSymptoms();
}
