package com.hemebiotech.analytics;

import java.util.List;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * This interface is the "tutti-fruity" interface of this program. It mixes together all four previous
 * methods to achieve the analysis process from raw data file to processed data file.
 *
 */
public interface ISymptomAnalyser {
    /**
     * STEP 1 : read symptom data from file and get a raw listing of symptoms
     * @return a raw listing of all Symptoms obtained from a data source, duplicates are possible/probable
     */
    List<String> getSymptoms ();

    /**
     * STEP 2 : sort symptoms
     * @param symptoms
     * @return ordered set of all Symptoms collected from a data source, hence without duplicates
     */
    TreeSet<String> sortSymptoms(List<String> symptoms);

    /**
     * STEP 3 : count symptoms
     * @param symptoms
     * @param sortedSymptoms
     * @return
     */
    TreeMap<String,Integer> countSymptoms (List<String> symptoms, TreeSet<String> sortedSymptoms);

    /**
     * STEP 4 : generate the file output with final sorted and counted data
     * @param mappedSymptoms : ordered list of symptoms with their corresponding
     */
    public void writeSymptom(TreeMap<String,Integer> mappedSymptoms);

}
