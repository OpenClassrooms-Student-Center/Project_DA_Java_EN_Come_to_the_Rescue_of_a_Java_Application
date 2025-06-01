import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Performs analytics on symptom data.
 //* Reads symptoms, counts occurrences, and writes sorted results to a file.
 */
public class AnalyticsCounter {

    /**
     * Processes symptom data by reading it from a file, counting occurrences,
     * and writing the results to another file.
     //* Uses ISymptomReader to load data, TreeMap to sort, and FileWriter to save.
     * 
     * @param inputFile  the path to the input file containing symptom data
     * @param outputFile the path where the result should be written
     */
    public static void processSymptoms(String inputFile, String outputFile) {
        // Create a reader object to fetch symptoms from the file
        ISymptomReader reader = new ReadSymptomDataFromFile(inputFile);

        // Read symptoms from the source
        List<String> symptoms = reader.getSymptoms();

        // Map to store symptom names and their occurrence counts
        Map<String, Integer> symptomCounts = new TreeMap<>();

        // Count each symptom
        for (String symptom : symptoms) {
            if (symptomCounts.containsKey(symptom)) {
                symptomCounts.put(symptom, symptomCounts.get(symptom) + 1);
            } else {
                symptomCounts.put(symptom, 1);
            }
        }

        // Write the sorted results to the output file
        try (FileWriter writer = new FileWriter(outputFile)) {
            for (Map.Entry<String, Integer> entry : symptomCounts.entrySet()) {
                writer.write(entry.getKey() + " = " + entry.getValue() + "\n");
            }
        } catch (IOException e) {
            System.err.println("Error writing to output file: " + e.getMessage());
        }
    }
}




// package com.hemebiotech.analytics;

// import java.io.BufferedReader;
// import java.io.FileReader;
// import java.io.FileWriter;

// public class AnalyticsCounter {
// 	private static int headacheCount = 0;	// initialize to 0
// 	private static int rashCount = 0;		// initialize to 0
// 	private static int pupilCount = 0;		// initialize to 0
	
// 	public static void main(String args[]) throws Exception {
// 		// first get input
// 		BufferedReader reader = new BufferedReader (new FileReader("symptoms.txt"));
// 		String line = reader.readLine();

// 		int i = 0;	// set i to 0
// 		int headCount = 0;	// counts headaches
// 		while (line != null) {
// 			i++;	// increment i
// 			System.out.println("symptom from file: " + line);
// 			if (line.equals("headache")) {
// 				headCount++;
// 				System.out.println("number of headaches: " + headCount);
// 			}
// 			else if (line.equals("rush")) {
// 				rashCount++;
// 			}
// 			else if (line.contains("pupils")) {
// 				pupilCount++;
// 			}

// 			line = reader.readLine();	// get another symptom
// 		}
		
// 		// next generate output
// 		FileWriter writer = new FileWriter ("result.out");
// 		writer.write("headache: " + headacheCount + "\n");
// 		writer.write("rash: " + rashCount + "\n");
// 		writer.write("dialated pupils: " + pupilCount + "\n");
// 		writer.close();
// 	}
// }
