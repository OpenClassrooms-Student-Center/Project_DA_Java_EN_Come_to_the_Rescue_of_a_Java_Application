package com.hemebiotech.analytics;

import java.util.List;

/**
 * Anything that will extract data from text or Lists and will use that data to
 * output a result file after analysing the data
 */
public interface OSymptomWriter {

    /**
     * If there is no data, will return null.
     * 
     * @param symptomList List containing the symptoms with no duplicates
     * @param listToCount List containing all the symptoms to count. May contain
     *                    duplicates.
     * @return Returns a string containing alphabetically the number of occurences
     *         of each symptom. One symptom per line.
     */
    String countOccurences(List<String> symptomList, List<String> listToCount);

    /**
     * If there is no data, will alert the user.
     * 
     * @param text Extracts the text result of the occurences of each symptom into
     *             an .out file
     */
    void generateOutputFile(String text);

}