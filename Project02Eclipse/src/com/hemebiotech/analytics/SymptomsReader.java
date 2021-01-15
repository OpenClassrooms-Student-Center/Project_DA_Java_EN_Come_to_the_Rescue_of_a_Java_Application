package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class SymptomsReader {

    public static void reader() throws Exception {
        BufferedReader reader = new BufferedReader(new FileReader("symptoms.txt"));

        ArrayList<String> symptomslist = new ArrayList<>();
        reader.lines().forEach(readLine -> {
            symptomslist.add(readLine);
        });

    }

}
