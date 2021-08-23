package com.hemebiotech.analytics;

import java.util.List;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Asking the user for the filename containing the symptoms
        System.out.println("Please enter the file name");
        String filename = scanner.nextLine();
        scanner.close();
        ReadSymptomDataFromFile rSymptomDataFromFile = new ReadSymptomDataFromFile(filename);

        // Analyse the file and store its content it in a List of String
        List<String> list = rSymptomDataFromFile.getSymptoms();

        // Get the different symptoms by removing the duplicates
        List<String> uniqueList = rSymptomDataFromFile.getUniqueSymptomNames(list);

        // Count the occurences of each symptom and output the results in a file
        ExtractDataFromText extractor = new ExtractDataFromText(uniqueList, list);
        extractor.extractData();

    }

}
