package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

import com.hemebiotech.analytics.interfaces.ISymptomAnalyzer;
import com.hemebiotech.analytics.interfaces.ISymptomInsightWriter;
import com.hemebiotech.analytics.interfaces.ISymptomReader;
import com.hemebiotech.analytics.interfaces.ISymptomWriter;
import com.hemebiotech.analytics.services.ReadSymptomDataFromFile;
import com.hemebiotech.analytics.services.SymptomAnalyzer;
import com.hemebiotech.analytics.services.WriteInsightToFile;
import com.hemebiotech.analytics.services.WriteSymptomDataToFile;
import com.hemebiotech.analytics.interfaces.ISymptominsightGenerator;
import com.hemebiotech.analytics.services.SymptomInsightGenerator;

/**
 * Orchestre la lecture, l'analyse et l'écriture des symptômes.
 */
public class AnalyticsCounter {

    public static void main(String[] args) {
        // Chemins des fichiers
        String inputFile = "symptoms.txt";      // fichier d'entrée
        String outputFile = "result.out";       // fichier de sortie globale
        String outinsightFile = "top5";
        		
        // Lecture des symptômes (List<String>)
        ISymptomReader reader = new ReadSymptomDataFromFile(inputFile);
        List<String> symptoms = reader.getSymptoms();
       
        // Analyse des symptômes (Map<String, Integer>)
        ISymptomAnalyzer analyzer = new SymptomAnalyzer();
        Map<String, Integer> symptomCounts = analyzer.countSymptoms(symptoms);

        // Écriture des résultats globaux 
        ISymptomWriter writer = new WriteSymptomDataToFile(outputFile);
        writer.writeSymptoms(symptomCounts);
        // Message 
        System.out.println("Traitement terminé. Résultats globaux écrits dans " + outputFile);
        
        ISymptominsightGenerator generator = new SymptomInsightGenerator();
        String top5 = generator.InsightGenerator(symptomCounts);
        System.out.println(top5);
        ISymptomInsightWriter insightwriter = new WriteInsightToFile();
        insightwriter.writeInsightGenerator(top5, outinsightFile);
        System.out.println("Traitement top 5 terminé. Résultats écrits dans " + outinsightFile);
    }
}
