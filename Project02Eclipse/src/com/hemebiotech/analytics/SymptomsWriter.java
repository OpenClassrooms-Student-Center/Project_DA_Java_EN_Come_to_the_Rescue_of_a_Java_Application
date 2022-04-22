package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

public class SymptomsWriter {
    /**
     * Remplissage du fichier de sortie a partir des symptoms.
     * @param symptoms La map Symptoms a remplir dans le doc.
     * @param filename Le fichier de Sortie.
     * @throws IOException Probleme d'ecriture sur le fichier.
     */
    public void write(Map<String, Integer> symptoms, String filename) throws IOException {
        Iterator<String> it = symptoms.keySet().iterator();
        FileWriter writer = new FileWriter (filename);
        while (it.hasNext()) {
            String symptom = it.next();
            writer.write(symptom + " : " + symptoms.get(symptom) + "\n");
        }
        writer.close();
    }
}
