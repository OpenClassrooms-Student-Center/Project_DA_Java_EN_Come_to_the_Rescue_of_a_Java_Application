package com.hemebiotech.analytics;

/**
 * Reads the content of a file with a list of symptoms and then counts the
 * number of occurrences
 * for each symptom and exports the list in alphabetical order to an output file
 *
 * @author Alberto Ruiz
 */
public interface ISymptomReader {
    /**
     * Read the contents from a text file
     */
    void ReadSymptomDataFromFile(String filePath);


}