package com.hemebiotech.analytics;

import java.util.List;
import java.util.TreeSet;

/**
 * This interface allows us to obtain a sorted set of strings (the symptoms),
 * this time without duplicates, which should come in handy in the process of
 * getting each symptom frequency.
 * Being a TreeSet, the set will automatically be ordered alphabetically.
 */
public interface ISymptomSorter {
    /**
     * @return ordered set of all Symptoms collected from a data source, hence without duplicates
     */
    TreeSet<String> sortSymptoms(List<String> symptoms);
}