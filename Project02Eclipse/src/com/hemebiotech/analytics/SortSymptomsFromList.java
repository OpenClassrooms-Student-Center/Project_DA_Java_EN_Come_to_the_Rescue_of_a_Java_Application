package com.hemebiotech.analytics;

import java.util.List;
import java.util.TreeSet;

public class SortSymptomsFromList implements ISymptomSorter {
    /**
     * @param symptoms - unordered listing of the symptoms from data file, duplicates included
     * @return an alphabetically ordered and duplicate-free collection of symptoms
     */

    @Override
    public TreeSet<String> sortSymptoms(List<String> symptoms) {
        TreeSet<String> sortedSymptoms = new TreeSet<>();
        sortedSymptoms.addAll(symptoms);
        return sortedSymptoms;
    }
}