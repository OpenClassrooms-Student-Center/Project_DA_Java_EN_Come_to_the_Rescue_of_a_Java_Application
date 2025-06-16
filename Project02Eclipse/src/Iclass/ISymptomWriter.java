package Iclass;

import java.util.Map;

/**
 * Interface pour reporter les résultats dans une sortie (ex: result.out)
 */
public interface ISymptomWriter {

    /**
     *
     * @param Map contenant les noms de symptômes et leur nombre d'occurrences
     */
    void writeSymptoms(Map<String, Integer> symptoms); 
}
