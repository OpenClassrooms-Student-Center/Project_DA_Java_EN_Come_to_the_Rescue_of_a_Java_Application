package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

/**
 * Cette classe {@code WriteSymptomDataToFile} implémente l'interface
 * {@code ISymptomWriter}
 * pour écrire les symptômes et leur nombre d'occurrences dans un fichier.
 */
public class WriteSymptomDataToFile implements ISymptomWriter {

    private String fileName;

    /**
     * Constructeur de la classe {@code WriteSymptomDataToFile}.
     *
     * @param fileName Le nom du fichier dans lequel écrire les symptômes.
     */
    public WriteSymptomDataToFile(String fileName) {
        this.fileName = fileName;
    }

    /**
     * Écrit les symptômes et leur nombre d'occurrences dans un fichier spécifié.
     *
     * @param symptoms Une Map associant les symptômes à leur nombre d'occurrences à
     *                 écrire.
     */
    @Override
    public void writeSymptoms(Map<String, Integer> symptoms) {
        try {
            FileWriter writer = new FileWriter(fileName);
            // Boucle sur la Map pour récupérer les informations et les écrire dans le
            // fichier.
            for (Map.Entry<String, Integer> entry : symptoms.entrySet()) {
                writer.write(entry.getKey() + ": " + entry.getValue() + "\n");
            }
            writer.close(); // Fermeture du writer.
        } catch (IOException e) { // Gestion des exceptions dans le catch.
            e.printStackTrace();
        }
    }
}
