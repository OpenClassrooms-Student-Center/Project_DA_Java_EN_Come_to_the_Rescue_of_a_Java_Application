import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

/**
 * Implementation of ISymptomWriter that writes symptoms and their counts to a file.
 //* Outputs each entry in the format "symptom = count", one per line.
 */
public class WriteSymptomDataToFile implements ISymptomWriter {

    private String filepath;

    /**
     * Constructor with the path to the output file.
     * 
     * @param filepath the path to the file where symptoms will be written
     */
    public WriteSymptomDataToFile(String filepath) {
        this.filepath = filepath;
    }

    /**
     * Writes the symptom count map to the specified file.
     * 
     * @param symptomCounts map of symptom names to their occurrence count
     */
    @Override
    public void writeSymptoms(Map<String, Integer> symptomCounts) {
        // Try to open the file and write each symptom with its count
        try (FileWriter writer = new FileWriter(filepath)) {
            for (Map.Entry<String, Integer> entry : symptomCounts.entrySet()) {
                writer.write(entry.getKey() + " = " + entry.getValue() + "\n");
            }
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }
}

