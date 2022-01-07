package com.hemebiotech.analytics;

import java.util.ArrayList;
/**
 * Execution principale du programme de tri d'une liste de Symptomes
 * 
 */
public class Main_Executer {
    
    public static void main(String args[])  { 
       
        //Step1: Lecture du fichier txt et stockage dans une raw list (readsymptomdatafromfile)
        String filepath = "symptoms.txt";           // Variable chemin du fichier txt

        ReadSymptomDataFromFile lecteur = new ReadSymptomDataFromFile(filepath);   // Création d'un objet ReadSymptomDataFromFile grace à son constructeur
        ArrayList<String> rawlist = new ArrayList<String>(lecteur.GetSymptoms());     // Appel de la fonction GetSymptoms pour stocker le fichier txt dans une liste

        //Step2: Traitement de la liste: renvoie une Liste triée d'objets Symptoms
        AnalyticsCounter Analyzer = new AnalyticsCounter(rawlist);

        // Step3 Ecriture sur un fichier result.out
        Analyzer.ResultGenerator();

    }

}
