package com.hemebiotech.analytics;

import java.util.ArrayList;
import java.util.TreeMap;

public class MapOccurenceCount {

    public TreeMap<String, Integer> countMapOccurence(ArrayList<String> inputArray)
    {
        //Creating a HashMap object with elements of inputArray as keys and their count as values
        TreeMap<String, Integer> elementCountMap = new TreeMap<>();

        //checking every element of the inputArray
        for (String i : inputArray)
        {
            if(elementCountMap.containsKey(i))
            {
                //If element is present in elementCountMap, incrementing it's count by 1
                elementCountMap.put(i, elementCountMap.get(i)+1);
            }
            else
            {
                //If element is not present in elementCountMap,
                //adding this element to elementCountMap with 1 as it's value
                elementCountMap.put(i, 1);
            }
        }

        return elementCountMap;
    }
}
