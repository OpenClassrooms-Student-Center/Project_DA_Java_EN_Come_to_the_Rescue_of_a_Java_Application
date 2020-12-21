package com.hemebiotech.analytics;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;





/**
 * @author fouziahajji
 * La classe WriteSymptomDataToFile permet de récupérer une Map et d'écrire ses résultats par ordre alphabétique
 * dans le fichier de sortie.
 */

public class WriteSymptomDataToFile implements ISymptomWriter{
	
	
		private String fileOutPut;
		private Map<String, Integer> symptoms;

	    /**
	     * @param fileOutPut fichier de sortie
	     * @param symptoms une map avec les symptoms par leur cle de valeur et le nombre d'occurences par valeur
	     */
	    public WriteSymptomDataToFile(String filepath, Map<String, Integer> ListOccurences) {
	        this.fileOutPut = filepath;
	        this.symptoms = ListOccurences;
	        
	       
	        
	    }
    	/*
			 * Utilise l'interface Entry pour récupérer les données de la map.
			 * 
			 * Chaque occurrence est écrite avec leurs valeurs respectives.
			 * 
			 * Capture l'exception possible.
			 * 
			 * Ferme le fichier une fois l'opération terminée ou si l'erreur est rencontrée.
			 * 
			 */
	    @Override
	    public void writeSymptoms(Map<String, Integer> MapList) throws IOException {
	    	
	    	
	
	         if ((fileOutPut != null) && (symptoms != null)) {
	                // Parcoure la Map pour écrire les symptômes dans le fichier
	                try {
	                    BufferedWriter writer = new BufferedWriter(new FileWriter(fileOutPut));
	                    for (Map.Entry<String, Integer> symptom : symptoms.entrySet()) {
	                        writer.write(symptom.getKey() + " = " + symptom.getValue() + "\n");
	                    }
	                    writer.close();
	                } catch (IOException e) {
	                    e.printStackTrace();
	                    
	                    
	                }
	            }
	        }
	    


}