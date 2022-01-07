package com.hemebiotech.analytics;

import java.util.ArrayList;

public class Main_Executer {
    
    public static void main(String args[]) throws Exception { 
       
        //Step1: Lecture du fichier txt et stockage dans une raw list (readsymptomdatafromfile)
        String filepath = "Symptoms.txt";           // Variable chemin du fichier
        ReadSymptomDataFromFile lecteur = new ReadSymptomDataFromFile(filepath);   // Création d'un objet ReadSymptomDataFromFile grace à son constructeur
        ArrayList<String> result = new ArrayList<String>(lecteur.GetSymptoms());     // Appel de la fonction GetSymptoms pour stocker le fichier txt dans une liste

        //Step2: Traitement: renvoie une Liste triée d'objets Symptoms (définis par un nom et un nombre d'occurences)
        AnalyticsCounter Analyzer = new AnalyticsCounter(result);


        // Step3 Ecriture sur un fichier result.out
        Analyzer.ResultGenerator();


    }

}
