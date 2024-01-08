package com.hemebiotech.analytics;

import java.util.Collections;
import java.util.List;


public class SortSymptomFromList{
    private List<String> listToSort;
    public SortSymptomFromList(List<String> listToSort){
        this.listToSort = listToSort;
    }


    /**
 * Order the list alphabetically
 */
    public List<String> sortSymptoms(){
        try {
            Collections.sort(listToSort);
            return (listToSort);
        } catch (Exception e) {
            return (null);
        }

        }


    }