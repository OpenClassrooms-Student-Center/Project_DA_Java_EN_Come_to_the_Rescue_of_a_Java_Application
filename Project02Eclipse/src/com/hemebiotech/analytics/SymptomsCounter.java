/**
 * SymptomsCounter Class creation as part of OCR Project 4 initiative
 *
 *  This class expects a List of strings with symptoms and produces a map object with distinct
 *  of symptoms and their respective count of occurrences
 *
 *
 * @author  Sébastien Vigé
 * @version 2.0
 * @since   2018-12-18
 */

package com.hemebiotech.analytics;

import java.util.*;

public class SymptomsCounter {

    //fields
   public  List<String> inputList;
   public  Map<String, Integer> results = new HashMap<String,Integer>();


    //constructor
    public SymptomsCounter (List<String> inputList) {
        this.inputList = inputList;
    }


    //public methods

    public Map<String, Integer> getSymptomsCount() {
    //scans the input list - if the key does not exists in the target map, it create a kv pair with the symptom as
    // key and 1 as value
    // if the key already exists, it takes the existing value and increment the count by 1
    // return the results map object

        for (String str: inputList) {
            //the map does not contain the key so we add the key and value 1
            if(!results.containsKey(str)) {
                results.put(str,1);
            } else {

                results.replace(str,results.get(str)+1);
            }


        }



    return results;
    }


}






