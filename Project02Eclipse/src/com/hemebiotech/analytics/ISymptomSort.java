package com.hemebiotech.analytics;

import java.util.Hashtable;
import java.util.List;

/**
 * For any class who needs to sort symptoms
 */
public interface ISymptomSort {
    /**
     * Function who count the number of recurrences of symptoms and sort them by key : name of symptoms and by value : number of recurrences
     * @param list
     * @return hashtable
     */
    Hashtable<String, Integer> CleanSymptomsList (List<String> list);
}
