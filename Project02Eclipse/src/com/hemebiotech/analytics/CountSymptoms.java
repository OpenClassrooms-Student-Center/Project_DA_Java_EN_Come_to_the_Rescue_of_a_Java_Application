package com.hemebiotech.analytics;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;

public class CountSymptoms {

    static void CountLines(String filename, Map<String, Integer> symptoms) throws FileNotFoundException {
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
    }
}
