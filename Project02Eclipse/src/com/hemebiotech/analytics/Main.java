package com.hemebiotech.analytics;

import java.io.IOException;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        AnalyticsCounter count = new AnalyticsCounter();

        ISymptomReader input = new ReadSymptomDataFromFile("Symptoms.txt");
        List<String> lireSymptoms = count.readSymptom(input);
        ICountAndSort countAndSort = new CountAndSortSymptoms(lireSymptoms);
        TreeMap<String, Integer> sortAndCount = count.sortAndCount(countAndSort);

        ISaveResult save = new SaveResult(sortAndCount);
        count.saveResult(save);

    }
}