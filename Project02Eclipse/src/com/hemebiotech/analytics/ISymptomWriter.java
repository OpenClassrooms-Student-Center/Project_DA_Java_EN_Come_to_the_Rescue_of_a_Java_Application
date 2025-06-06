package com.hemebiotech.analytics;

import java.util.Map;

/**
 * Interface pour reporter les résultats dans une sortie (ex: result.out)
 */
public interface ISymptomWriter {

    /**
     * Écrit les symptômes et leur fréquence dans un fichier de sortie.
     *
     * @param symptoms une Map contenant les noms de symptômes et leur nombre d'occurrences
     */
    void writeSymptoms(Map<String, Integer> symptoms); // méthode attendue
}
