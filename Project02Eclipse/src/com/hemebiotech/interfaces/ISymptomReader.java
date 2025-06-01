import java.util.List;

/**
 * Interface representing a reader capable of extracting symptom data from a source.
 //* Used to allow multiple implementations of symptom data readers (e.g., from file, database, API).
 */
public interface ISymptomReader {

    /**
     * Reads symptom data from a data source.
     //* Must be implemented by classes that fetch symptom data (e.g., from a file).
     //* Should return a list of symptom names, possibly with duplicates.
     * 
     * @return List of symptom names as Strings
     */
    List<String> getSymptoms(); // Get the list of symptoms read from a source
}
