package com.hemebiotech.analytics;

import java.util.Map;
/**
 * L'interface ISymptomWriter définit la méthode pour écrire les symptômes.
 */
public interface ISymptomWriter {
    /**
     * On écrit les symptômes et leurs occurrences.
     * On utilise le parametre symptoms de la map contenant les symptômes et leurs occurrences.
     */
    void writeSymptoms(Map<String, Integer> symptoms);
}
