package com.hemebiotech.analytics;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CountSymptoms {

    Map<String, Integer> getSymptoms(String filename) throws FileNotFoundException {

        Map<String, Integer> symptoms = new TreeMap<>();
        Scanner file = new Scanner(new File(filename));

        while (file.hasNext()) {

            String line = file.nextLine();
            Integer count = symptoms.get(line);

            if (count != null)
                count++;
            else
                count = 1;
            symptoms.put(line, count);
        }
        file.close();
        return symptoms;
    }
}
