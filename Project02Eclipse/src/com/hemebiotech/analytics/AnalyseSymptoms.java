package com.hemebiotech.analytics;

import java.util.List;
import java.util.TreeMap;
import java.util.TreeSet;

public class AnalyseSymptoms implements ISymptomAnalyser {

    /**
     * STEP 1 : read symptom data from file and get a raw listing of symptoms
     *
     * If no data is available, return an empty List
     *
     * @return a raw listing of all Symptoms obtained from a data source, duplicates are
     * possible/probable
     */
    @Override
    public List<String> getSymptoms() {
        ISymptomReader symptomReader = new ReadSymptomDataFromFile("symptoms.txt");
        return symptomReader.getSymptoms();
    }

    /**
     * STEP 2 : sort symptoms
     *
     * @return ordered set of all Symptoms collected from a data source,
     * hence without duplicates
     */
    @Override
    public TreeSet<String> sortSymptoms(List<String> symptoms) {
        ISymptomSorter symptomSorter = new SortSymptomsFromList();
        return symptomSorter.sortSymptoms(symptoms);
    }

    /**
     * STEP 3: associate symptoms to their number of occurrences
     *
     * @param symptoms       a raw listing allowing duplicates
     * @param sortedSymptoms an ordered listing without duplicates
     * @return a map <symptom, number of symptom occurrences>
     */
    @Override
    public TreeMap<String, Integer> countSymptoms(List<String> symptoms,
                                                  TreeSet<String> sortedSymptoms) {
        ISymptomCounter symptomCounter = new CountSymptomsFromList();
        return symptomCounter.countSymptoms(symptoms, sortedSymptoms);
    }

    /**
     * STEP 4 : write the analyzed data in result.out
     *
     * returns a file output with the final form of symptom data : sorted list with each
     * symptom number of occurrences
     *
     */
    @Override
    public void writeSymptom(TreeMap<String, Integer> mappedSymptoms) {
        ISymptomWriter symptomWriter = new WriteSymptomAnalyticsInFile("result.out");
        symptomWriter.writeSymptom(mappedSymptoms);
    }
}