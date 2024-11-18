package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
/**
 * La classe WriteSymptomDataToFile implémente l'interface ISymptomWriter pour écrire les symptômes dans un fichier.
 */

public class WriteSymptomDataToFile implements ISymptomWriter {

    /**
     * On écrit les symptômes et leurs occurrences dans le fichier en sortie.
     * On utilise les parametres symptoms de la map contenant les symptômes et leurs occurrences.
     */
    @Override
    public void writeSymptoms(Map<String, Integer> symptoms) {
        PrintWriter writer = null;
        try {
            writer = new PrintWriter(new FileWriter("result.out"));
            for (Map.Entry<String, Integer> entry : symptoms.entrySet()) {
                writer.println(entry.getKey() + " " + entry.getValue());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (writer != null) {
                writer.close();
            }

        }
    }
}
