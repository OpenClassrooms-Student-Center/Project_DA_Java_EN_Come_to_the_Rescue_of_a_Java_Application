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

        // Analyse the file and get it in a List of String
        // TODO: Ajouter un try si nom de fichier mauvais + while
        List<String> list = rSymptomDataFromFile.GetSymptoms();
        // Get the different symptoms by removing the duplicates
        List<String> uniqueList = rSymptomDataFromFile.GetUniqueSymptomNames(list);

        // Count the occurences of each different symptoms
        String results = SymptomCounter.countOccurences(uniqueList, list);

        // Output a results file
        GenerateOutputResults.generate(results);

    }

}
