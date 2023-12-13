package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class WriteSymptomDataToFile implements ISymptomWriter {

    private String fileName;

    // prend en parametre le nom de fichier "fileName"
    public WriteSymptomDataToFile(String fileName) {
        this.fileName = fileName;
    }

    @Override
    // prend en paramettre une map contenant les symptoms
    public void writeSymptoms(Map<String, Integer> symptoms) {
        try {
            FileWriter writer = new FileWriter(fileName);
            // boucle sur la map pour récupérer les infos et les ecrirent ensuite
            for (Map.Entry<String, Integer> entry : symptoms.entrySet()) {
                writer.write(entry.getKey() + ": " + entry.getValue() + "\n");
            }
            writer.close(); // fermeture du writer
        } catch (IOException e) { // on gere les exceptions dans le catch
            e.printStackTrace();
        }
    }
}
