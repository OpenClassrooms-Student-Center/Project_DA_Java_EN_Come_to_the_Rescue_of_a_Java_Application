package com.hemebiotech.analytics;

import java.util.Map;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * La classe WriteSymptomDataToFile est une implémentation de l'interface ISymptomWriter
 * pour écrire les données des symptômes dans un fichier spécifié.
 *
 * Cette classe prend un nom de fichier en entrée lors de l'instanciation et écrit une map des symptômes
 */
public class WriteSymptomDataToFile implements ISymptomWriter {
	private String filepath;
	public WriteSymptomDataToFile(String filepath) {
		this.filepath = filepath;
	}
	@Override
		public void writeSymptoms(Map<String, Integer> symptoms) {
	        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filepath))) {
	            for (Map.Entry<String, Integer> entry : symptoms.entrySet()) {
	                writer.write(entry.getKey() + ": " + entry.getValue());
	                writer.newLine();
	            }
	            System.out.println("Les symptômes ont été écrits avec succès.");
	        } catch (IOException e) {
	            System.out.println("Erreur lors de l'écriture des symptômes dans le fichier : " + e.getMessage());
	        }
}

}
	

