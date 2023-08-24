package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadSymptomDataFromFile {

    private final String inputFile; // file path to list of symptoms file

    ArrayList<String> result = new ArrayList<>();


    /**
     * File path is passed to constructor
     *
     * @param filePath returns the value of the location where the input file is
     */
    public ReadSymptomDataFromFile(String filePath) {
        this.inputFile = filePath;
    }


    /**
     * Read the contents from a text file and filter out any blank lines within the file
     *
     * @return result
     */
    public List<String> readSymptoms() {

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

        return result;
    }

}