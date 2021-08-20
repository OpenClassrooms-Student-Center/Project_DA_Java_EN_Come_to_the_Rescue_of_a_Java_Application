package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SymptomCounter {

    /**
     * Takes two lists. Outputs a file.
     * 
     * @param symptomList
     * @param listToCount
     * @throws IOException
     */
    public static String countOccurences(List<String> symptomList, List<String> listToCount) {
        List<String> result = new ArrayList<String>();

        symptomList.stream().forEach((uniqueSymptom) -> {
            result.add(uniqueSymptom + " : " + Collections.frequency(listToCount, uniqueSymptom) + "\n");
        });

        return String.join("", result);
    }

}
