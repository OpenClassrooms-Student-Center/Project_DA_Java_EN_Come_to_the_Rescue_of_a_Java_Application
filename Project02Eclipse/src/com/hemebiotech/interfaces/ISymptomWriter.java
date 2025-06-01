import java.util.Map;

/**
 * Interface representing a writer that outputs symptom data.
 //* Can be implemented to write to a file, console, database, etc.
 */
public interface ISymptomWriter {

    /**
     * Writes symptom data to a destination (e.g., file).
     //* Implementations decide where and how to write the data.
     * 
     * @param symptomCounts a Map with symptom names and their occurrence counts
     */
    void writeSymptoms(Map<String, Integer> symptomCounts);
}
