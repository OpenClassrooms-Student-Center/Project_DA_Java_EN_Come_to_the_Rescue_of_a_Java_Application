package com.hemebiotech.analytics;

import java.util.Map;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public  class WriteSymptomDataToFile implements ISymptomWriter {
	
	private String outputFilePath;
	
		public WriteSymptomDataToFile(String outputFilePath) {
		this.outputFilePath = outputFilePath;
			}
	  	
	    public void writeSymptoms(Map<String, Integer> symptoms) // parametre de la methode
	    {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath))) 
        {
            for (Map.Entry<String, Integer> entry : symptoms.entrySet()) { // on cree une boucle avec for pour parcourir le Map
                String line = entry.getKey() + " = " + entry.getValue(); // + on va concaterner une clé a une valeur
                writer.write(line); // Écriture dans le fichier 
                writer.newLine(); // Saut de ligne 
            }
            System.out.println("Les résultats ont été écrits dans " + outputFilePath); //Message de succès 
        } catch (IOException erreur) { // bloc de catch pour erreur
            System.err.println("Erreur lors de l'écriture dans le fichier : " + erreur.getMessage()); // message d'erreur
            erreur.printStackTrace(); // pile d'appel pour comprendre l'erreur. Affiche l’historique complet des méthodes appelées jusqu’au moment où l’erreur s’est produite, pour aider à comprendre où et pourquoi le problème est survenu.
        }
    }
}