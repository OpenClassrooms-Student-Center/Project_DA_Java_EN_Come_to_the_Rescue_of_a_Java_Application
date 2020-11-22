package com.hemebiotech.analytics;
import java.util.ArrayList;
import java.util.Hashtable;

/**
 * Anything that will write symptom data from hastable list.
 */
public interface ISymptomResultWriter {
    /**
     * Function who create a file and write to it all the name of symptoms and their number of recurrences from the datasource
     * The hastable list must have for key the name of symptom and for value the number of recurrences
     * @param listSymptomsClean
     */
    void WriteSymptoms(Hashtable<String, Integer> listSymptomsClean);
}
