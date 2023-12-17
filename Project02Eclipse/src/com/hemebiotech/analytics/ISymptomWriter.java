package com.hemebiotech.analytics;

import java.util.Map;

/**
 * L'interface {@code ISymptomWriter} définit une méthode pour écrire les
 * symptômes et leur nombre d'occurrences.
 */
public interface ISymptomWriter {

    /**
     * Écrit les symptômes et leur nombre d'occurrences dans un format spécifique.
     *
     * @param symptoms Une Map associant les symptômes à leur nombre d'occurrences à
     *                 écrire.
     */
    public void writeSymptoms(Map<String, Integer> symptoms);
}
