package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

public class Main {

	public static void main(String[] args) {
		 // Création d'une instance de ISymptomReader pour lire les symptômes depuis un fichier
        ISymptomReader reader = new ReadSymptomDataFromFile(System.getProperty("user.dir")+"/Guittoun-Thibault-debug-java/Project02Eclipse/symptoms.txt");
        
        // Création d'une instance de ISymptomWriter pour écrire les résultats dans un fichier
        ISymptomWriter writer = new WriteSymptomDataToFile(System.getProperty("user.dir")+"/Guittoun-Thibault-debug-java/Project02Eclipse/result.out");
        
        // Création d'une instance de AnalyticsCounter qui gère l'analyse des symptômes
        AnalyticsCounter analyticsCounter = new AnalyticsCounter(reader, writer);
        
        // Lecture des symptômes depuis le fichier et stockage dans une liste
        List<String> symptomList = analyticsCounter.getSymptoms();
        
        // Comptage du nombre d'occurrences de chaque symptôme dans la liste
        Map<String, Integer> symptomMap = analyticsCounter.countSymptoms(symptomList);
        
        // Tri des symptômes par ordre alphabétique
        Map<String, Integer> sortedMap = analyticsCounter.sortSymptoms(symptomMap);
        
        // Écriture des résultats triés dans le fichier de sortie
        analyticsCounter.writeSymptoms(sortedMap);
	}

}