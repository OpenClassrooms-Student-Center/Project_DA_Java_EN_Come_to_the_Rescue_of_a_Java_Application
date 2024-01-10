package com.hemebiotech.analytics;

import java.util.HashMap;
import java.util.List;

public class CountSymptomFromList {
    private List<String> listSort;
    public CountSymptomFromList(List<String> listSort){
        this.listSort = listSort;
}

public HashMap<String,Integer> CountSymptoms(){
String actualSymptoms = listSort.get(0); //initializes the first symptom
        int count = 0;
        HashMap<String,Integer> mapSortAndCount = new HashMap<String,Integer>();
        for(int i=0; i<listSort.size(); i++){ // browse the list sort
            if (listSort.get(i).equals(actualSymptoms)){
                count++;
            }
            else{ // all same symptoms follow because the list is sort alphabetically
                mapSortAndCount.put(actualSymptoms,count); // insert the actual symptom and this occurrence in the list
                count =1; // first first appearance of the new symptom
                actualSymptoms = listSort.get(i); // take the next symptom
            }
        }
        mapSortAndCount.put(actualSymptoms,count); // insert the last symptom in the list
        return mapSortAndCount;
    }}