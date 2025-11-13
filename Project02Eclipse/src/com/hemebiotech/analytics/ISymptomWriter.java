package com.hemebiotech.analytics;

import java.io.IOException;
import java.util.Map;

/**
 * Interface for writing symptoms to a data destination.
 * Each entry in the map represents a symptom (key) and its corresponding occurrence count (value).
 * Implementations can write to files, databases, or other output formats.
 * 
 * @author Rebecca Guimaraes
 */
public interface ISymptomWriter {

    /**
     * Writes the symptoms and their counts to a data destination.
     *
     * @param symptoms A map of symptom names as keys and their occurrence counts as values.
     * @throws IOException If an error occurs while writing to the output destination.
     */
    void writeSymptoms(Map<String, Integer> symptoms) throws IOException;
}
