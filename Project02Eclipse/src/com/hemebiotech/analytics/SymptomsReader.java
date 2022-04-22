package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class SymptomsReader {
    /**
     *
     * Creation et remplissage du fichier d'entree sur une Map.
     * @param filename Le nom du fichier a lire.
     * @return la Map remplie avec les symptoms triés sans occurrence par ordre alphabetique.
     * @throws IOException Si le fichier est introuvable ou impossible a lire.
     */
    public Map<String, Integer> read(String filename) throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String line = reader.readLine();
        Map<String, Integer> symptoms = new TreeMap<>();

        while (line != null) {
            if (!symptoms.containsKey(line)) {
                symptoms.put(line, 1);
            } else {
                symptoms.put(line, symptoms.get(line) + 1);
            }
            line = reader.readLine();
        }
        return symptoms;
    }
}
