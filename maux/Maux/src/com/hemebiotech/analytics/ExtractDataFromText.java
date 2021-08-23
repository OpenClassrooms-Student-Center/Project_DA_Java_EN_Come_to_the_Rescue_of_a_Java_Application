package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ExtractDataFromText implements OSymptomWriter {

    private List<String> uniqueList;
    private List<String> fullList;

    /**
     * 
     * @param uniqueList List containing symptoms to look for and count. Contains no
     *                   duplicates
     * @param fullList   List containing all occurences of all symptoms, raw list
     *                   with possible duplicates
     */
    public ExtractDataFromText(List<String> uniqueList, List<String> fullList) {
        this.uniqueList = uniqueList;
        this.fullList = fullList;
    }

    @Override
    public String countOccurences(List<String> symptomList, List<String> listToCount) {

        if (!symptomList.isEmpty() && !listToCount.isEmpty()) {
            List<String> result = new ArrayList<>();

            symptomList.stream().forEach(uniqueSymptom -> result
                    .add(uniqueSymptom + " : " + Collections.frequency(listToCount, uniqueSymptom) + "\n"));

            return String.join("", result);
        } else
            return null;
    }

    @Override
    public void generateOutputFile(String text) {
        if (text != null) {
            try (FileWriter writer = new FileWriter("result.out")) {
                writer.write(text);
                System.out.println(text);
                System.out.println("\nOutput file generated successfully.");

            } catch (IOException e) {
                System.err.println("Error generating output file, check your configuration and permissions.");
            }
        } else
            System.err.println("No data");
    }

    /**
     * Extracts the data from the lists to output a results file containing the
     * symptoms and the number of time they occur
     */
    public void extractData() {
        String results = countOccurences(uniqueList, fullList);
        generateOutputFile(results);
    }

}
