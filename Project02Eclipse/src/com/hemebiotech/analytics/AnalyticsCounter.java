package com.hemebiotech.analytics;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * The AnalyticsCounter program reads contents of a file and exports an
 * alphabetized list
 * and the frequency of how many times they show up in the file.
 *
 * @author Alberto Ruiz
 */
public class AnalyticsCounter implements SymptomReaderInterface {

    String exportFile = ".\\Project02Eclipse\\results.out"; // file path of file created during SaveToFileSymptoms() method
    SortedMap<String, Integer> frequencyMap = new TreeMap<>();

    public AnalyticsCounter(List<String> symptomList) {
        countSymptoms(symptomList);
    }

    public Map<String, Integer> countSymptoms(List<String> symptomList) {

        // for-each loop is used to traverse through arrayList named "result"
        for (String s : symptomList) {
            Integer count = frequencyMap.get(s); // assigns the integer value associated to the symptom found in
            // SortedMap to the "count" variable

            // assigns the value of zero if the integer value is NULL. this happens as all
            // integer values are not initialized during the first time this runs
            if (count == null) {
                count = 0;
            }

            frequencyMap.put(s, count + 1); // increments the integer value each time symptom name is encountered in the
            // loop
        }
        return frequencyMap;
    }


    public void printToScreenSymptoms(Map<String, Integer> mapCounter) {

        for (Map.Entry<String, Integer> entry : mapCounter.entrySet()) {
            System.out.println(entry.getKey() + "=" + entry.getValue());
        }
    }

    public void saveToFileSymptoms(Map<String, Integer> mapCounter) {

        File file = new File(exportFile); // location of file to open

        BufferedWriter bf = null;

        try {

            // create new BufferedWriter for the output file
            bf = new BufferedWriter(new FileWriter(file));

            // iterates through "frequencyMap" content
            for (Map.Entry<String, Integer> entry : mapCounter.entrySet()) {

                bf.write(entry.getKey() + "=" + entry.getValue()); // writes a new line with Key and value separated by
                // an equal sign to file

                bf.newLine(); // Separate next line as a new line
            }

            bf.flush(); // remove all data present in the writer
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            try {
                assert bf != null;
                bf.close(); // close the stream
            } catch (Exception ignored) {
            }
        }

    }
}