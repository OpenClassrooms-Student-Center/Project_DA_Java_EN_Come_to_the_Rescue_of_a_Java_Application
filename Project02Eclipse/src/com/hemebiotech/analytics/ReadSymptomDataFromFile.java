package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

public class ReadSymptomDataFromFile {

    private final String inputFile; // file path to list of symptoms file

    ArrayList<String> result = new ArrayList<>();

    String exportFile = ".\\Project02Eclipse\\results.out"; // file path of file created during SaveToFileSymptoms() method

    SortedMap<String, Integer> frequencyMap = new TreeMap<>();

    /**
     * File path is passed to constructor
     */
    public ReadSymptomDataFromFile(String filePath) {
        this.inputFile = filePath;
    }

    /**
     * Read the contents from a text file and filter out any blank lines within the
     * file
     */
    @SuppressWarnings("CallToPrintStackTrace")
    public void readSymptoms() {

        // Read the contents of a file
        if (inputFile != null) {

            try {
                BufferedReader reader = new BufferedReader(new FileReader(inputFile)); // Reads characters from file

                String line = reader.readLine(); // Saves the line read from inputFile into a String variable named
                // "line"

                while (line != null) { // Runs until the "line" variable is NULL

                    if (!line.isEmpty()) { // Checks for empty lines in text file. If length of "line" variable is
                        // not zero, then it adds the content of the "line" variable to result
                        result.add(line);
                    }

                    line = reader.readLine(); // Saves the next line read from inputFile into String variable named
                    // "line"
                }

                reader.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    /**
     * Read the contents of a file and stores the name of symptom as the Key and the
     * number of times it shows up in the file as an INT mapped value
     */
    public void countSymptoms() {

        // for-each loop is used to traverse through arrayList named "result"
        for (String s : result) {
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
    }

    /**
     * Use a for-loop to traverse through "frequencyMap" object and prints the
     * content to console
     */
    public void printToScreenSymptoms() {

        for (Map.Entry<String, Integer> entry : frequencyMap.entrySet()) {
            System.out.println(entry.getKey() + "=" + entry.getValue());
        }
    }

    /**
     * Creates and saves a file with contents of "frequencyMap" object
     */
    @SuppressWarnings("CallToPrintStackTrace")
    public void saveToFileSymptoms() {

        File file = new File(exportFile); // location of file to open

        BufferedWriter bf = null;

        try {

            // create new BufferedWriter for the output file
            bf = new BufferedWriter(new FileWriter(file));

            // iterates through "frequencyMap" content
            for (Map.Entry<String, Integer> entry : frequencyMap.entrySet()) {

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