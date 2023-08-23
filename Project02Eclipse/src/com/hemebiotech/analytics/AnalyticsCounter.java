package com.hemebiotech.analytics;

/**
 * The AnalyticsCounter program reads contents of a file and exports an
 * alphabetized list
 * and the frequency of how many times they show up in the file.
 *
 * @author Alberto Ruiz
 */
public class AnalyticsCounter {

    public static void main(String[] args) {

        String inputFile = ".\\Project02Eclipse\\symptoms.txt";
        ReadSymptomDataFromFile readFile = new ReadSymptomDataFromFile(inputFile);
        readFile.readSymptoms();
        readFile.countSymptoms();
        readFile.printToScreenSymptoms();
        readFile.saveToFileSymptoms();
    }
}