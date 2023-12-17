package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        ISymptomReader reader = new ReadSymptomDataFromFile("Project02Eclipse/symptoms.txt");
        ISymptomWriter writer = new WriteSymptomDataToFile("result.out");
        AnalyticsCounter analyticsCounter = new AnalyticsCounter(reader, writer);

        // récupérations des symptomes
        List<String> symptoms = analyticsCounter.getSymptoms();
        System.out.println("\n Tout les symptomes : \n" + symptoms + " \n");

        // dénombrement des symptomes
        Map<String, Integer> countSymptoms = analyticsCounter.countSymptoms(symptoms);
        System.out.println("map des symptomes comptés : \n" + countSymptoms + " \n");

        // trie des symptomes par ordre alphabétique :
        Map<String, Integer> sortedsymptoms = analyticsCounter.sortSymptoms(countSymptoms);
        System.out.println("map triée par ordre alphabétique : \n" + sortedsymptoms + " \n");

        // Ecriture des résultats dans un fichier
        analyticsCounter.writeSymptoms(sortedsymptoms);
    }
}