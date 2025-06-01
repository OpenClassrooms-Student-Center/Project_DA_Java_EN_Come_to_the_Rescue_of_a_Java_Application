import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Class responsible for reading symptom data from a text file.
 //* Implements the ISymptomReader interface to read symptoms line by line from a file.
 */
public class ReadSymptomDataFromFile implements ISymptomReader {

    private String filepath;

    /**
     * Constructor with the path to the symptom data file.
     //* The filepath should point to a text file with one symptom per line.
     * 
     * @param filepath the path to the file containing symptoms
     */
    public ReadSymptomDataFromFile(String filepath) {
        this.filepath = filepath; // Store the file path
    }

    /**
     * Reads symptoms from a text file and returns them as a list.
     //* Opens the file using BufferedReader and adds each line (symptom) to the list.
     //* If the file cannot be read, the exception is caught and printed.
     * 
     * @return a list of symptoms as Strings
     */
    @Override
    public List<String> getSymptoms() {
        List<String> symptoms = new ArrayList<>();

        // Try to open and read the file line by line
        try (BufferedReader reader = new BufferedReader(new FileReader(filepath))) {
            String line;

            // Read each line until the end of the file
            while ((line = reader.readLine()) != null) {
                symptoms.add(line); // Add the symptom to the list
            }
        } catch (IOException e) {
            // If the file cannot be read, display the error
            System.err.println("Error reading file: " + e.getMessage());
        }

        return symptoms; // Return the list of symptoms
    }
}



// package com.hemebiotech.analytics;

// import java.io.BufferedReader;
// import java.io.FileReader;
// import java.io.IOException;
// import java.util.ArrayList;
// import java.util.List;

// /**
//  * Simple brute force implementation
//  *
//  */
// public class ReadSymptomDataFromFile implements ISymptomReader {

// 	private String filepath;
	
// 	/**
// 	 * 
// 	 * @param filepath a full or partial path to file with symptom strings in it, one per line
// 	 */
// 	public ReadSymptomDataFromFile (String filepath) {
// 		this.filepath = filepath;
// 	}
	
// 	@Override
// 	public List<String> GetSymptoms() {
// 		ArrayList<String> result = new ArrayList<String>();
		
// 		if (filepath != null) {
// 			try {
// 				BufferedReader reader = new BufferedReader (new FileReader(filepath));
// 				String line = reader.readLine();
				
// 				while (line != null) {
// 					result.add(line);
// 					line = reader.readLine();
// 				}
// 				reader.close();
// 			} catch (IOException e) {
// 				e.printStackTrace();
// 			}
// 		}
		
// 		return result;
// 	}

// }
