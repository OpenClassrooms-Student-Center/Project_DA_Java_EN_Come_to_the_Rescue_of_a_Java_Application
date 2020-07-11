package com.hemebiotech.analytics;

import com.hemebiotech.helpers.interfaceHelpers.IMapOccurenceCount;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class MapOccurenceCount implements IMapOccurenceCount {

    @Override
    public Map<String, Integer> countMapOccurence(List<String> inputArray)
    {
        //Creating a TreeMap object with elements of inputArray as keys and their count as values
        Map<String, Integer> elementCountMap = new TreeMap<>();

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
