/**
 * Entry point of the application.
 //* Delegates the main logic to the AnalyticsCounter class for better separation of concerns.
 */
public class Main {

    /**
     * Main method that starts the application.
     //* Calls the processing logic from AnalyticsCounter.
     * 
     * @param args command-line arguments (not used in this version)
     */
    public static void main(String[] args) {
        // Start the analysis process
        AnalyticsCounter.processSymptoms("symptoms.txt", "result.out");
    }
}
