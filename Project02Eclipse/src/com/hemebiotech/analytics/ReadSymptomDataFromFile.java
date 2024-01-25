package com.hemebiotech.analytics;

// The line `import java.io.BufferedReader;` is importing the `BufferedReader` class from the `java.io`
// package. This class is used to read text from a character-input stream, such as a file. It allows
// you to read data line by line from a file.
import java.io.BufferedReader;
// The line `import java.io.FileReader;` is importing the `FileReader` class from the `java.io`
// package. This class is used to read characters from a file. It allows you to read data from a file
// character by character or in larger chunks. In this specific code, it is used to read the symptom
// data from a file in the `getSymptoms` method of the `ReadSymptomDataFromFile` class.
import java.io.FileReader;
// The line `import java.io.IOException;` is importing the `IOException` class from the `java.io`
// package. This class is used to handle input/output exceptions that may occur during file operations,
// such as reading or writing data to a file. By importing this class, we can catch and handle any
// `IOException` that may occur in the code.
import java.io.IOException;
// The line `import java.util.ArrayList;` is importing the `ArrayList` class from the `java.util`
// package. This class is a part of the Java Collections Framework and is used to create dynamic
// arrays, which can grow or shrink in size as needed. In this specific code, the `ArrayList` class is
// used to store the symptoms read from the file in a list.
import java.util.ArrayList;
// The line `import java.util.List;` is importing the `List` interface from the `java.util` package.
// The `List` interface is a part of the Java Collections Framework and is used to create ordered
// collections of elements. In this specific code, the `List` interface is used to define the type of
// the `symptoms` variable in the `getSymptoms` method of the `ReadSymptomDataFromFile` class. It
// ensures that the `symptoms` variable can hold a collection of elements in a specific order.
import java.util.List;
/**
 * The ReadSymptomDataFromFile class implements the ISymptomReader interface
 * to read symptom data from a file.
 *
 * Usage:
 * - Create an instance of ReadSymptomDataFromFile.
 * - Call the getSymptoms method, providing the file path as a parameter.
 * - The method returns a list of symptoms read from the specified file.
 *
 * @author Mauricio Lopez
 * @version 1.0
 * @see ISymptomReader
 */
public class ReadSymptomDataFromFile implements ISymptomReader {
	/**
     * Reads symptoms from a specified file and returns a list of symptoms.
     *
     * @param inputFile The path to the file containing symptom data.
     * @return A list of symptoms read from the file.
     * @see ISymptomReader#getSymptoms(String)
     */
	
	public List<String> getSymptoms(String inputFile) {
		// Create a list to store the symptoms.
		List<String> symptoms = new ArrayList<>();
		
		
		// The code `try (BufferedReader reader = new BufferedReader (new FileReader(inputFile))){` is
		// creating a new instance of the `BufferedReader` class and initializing it with a new instance of
		// the `FileReader` class.
		try (BufferedReader reader = new BufferedReader (new FileReader(inputFile))){
			// Read the first line of the file.
			String line = reader.readLine();
			
			// Iterate through the file line by line.
			while (line != null) {
				// Add the symptom to the list after trimming spaces and converting to lowercase.
				symptoms.add(line.trim().toLowerCase());
				// Read the next line.
				line=reader.readLine();
			}
		}catch(IOException e){
			// Handle exceptions and print error message
            System.err.println("error"+e.getMessage());
        } 
		// Return the list of symptoms.
		return symptoms;
	}

}
