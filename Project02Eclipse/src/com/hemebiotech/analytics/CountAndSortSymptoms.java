package com.hemebiotech.analytics;

import java.util.*;

public class CountAndSortSymptoms implements ICountAndSort {

    private List<String> list;

    public CountAndSortSymptoms(List<String> list)
    {
        this.list = list;
    }

    /**
     *
     * @return count and sort method will return a map (key, value) sorted and counted...
     */
    @Override
    public TreeMap<String, Integer> countAndSort() {
        Set<String> noDuplicateSet = new HashSet<String>(list); // Delete duplicates
        List<String> noDuplicateList = new ArrayList<String>(noDuplicateSet); // new list without duplicates

        Map<String,Integer> symptomsOccurrence = new HashMap(); //Temporary Map to get (symptoms, occurrence)

        for (String symptom : noDuplicateList) { // fill the Map with symptoms(key) and occurrences(value)
            symptomsOccurrence.put(symptom,Collections.frequency(list,symptom));
        }

        TreeMap<String, Integer> mapSorted = new TreeMap<String, Integer>(); //TreeMap to sort alphabetically

        mapSorted.putAll(symptomsOccurrence); //fill the TreeMap with our temporary Map
        return mapSorted;
    }

}
