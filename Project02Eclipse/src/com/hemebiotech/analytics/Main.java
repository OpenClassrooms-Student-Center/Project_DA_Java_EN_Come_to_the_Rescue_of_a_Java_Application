package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;
/**
 * La classe Main est la classe de pilotage du programme.
 */
public class Main {
    /**
     * Méthode principale du programme.
     *
     */
    public static void main(String[] args) {

        // On instancie les objets ISymptomReader et ISymptomWriter
        ISymptomReader reader = new ReadSymptomDataFromFile("C:\\Users\\Nabil\\IdeaProjects\\Ben-khemis-Nabil-debug-Java\\Project02Eclipse\\symptoms.txt");
        ISymptomWriter writer = new WriteSymptomDataToFile();

        // On instancie l'objet AnalyticsCounter
        AnalyticsCounter analyticsCounter = new AnalyticsCounter(reader, writer);

        // On Récupére les symptômes
        List<String> symptoms = analyticsCounter.getSymptoms();

        // On compte les symptômes
        Map<String, Integer> countedSymptoms = analyticsCounter.countSymptoms(symptoms);

        // On trie les symptômes par ordre alphabétique
        Map<String, Integer> sortedSymptoms = analyticsCounter.sortSymptoms(countedSymptoms);

        // On écrit les résultats dans le fichier final
        analyticsCounter.writeSymptoms(sortedSymptoms);
    }
}
