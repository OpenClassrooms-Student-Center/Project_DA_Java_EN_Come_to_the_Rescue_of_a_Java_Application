package com.hemebiotech.analytics;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class AnalyticsCounter {

	
	// create function to count words
	public void countEachWord(String fileName, Map<String, Integer> words) throws FileNotFoundException {

		// Create file input and Scanner
		
		Scanner file = new Scanner(new File(fileName));

		// Read through file and find words
		while (file.hasNext()) {
			String word = file.next();
			Integer count = words.get(word);

			// Determine if the word is in the Map
			if (count != null)
				count++;

			else
				count = 1;

			// putting values in the Map
			words.put(word, count);
		}

		// Close
		file.close();

	}

	public static void main(String args[]) throws FileNotFoundException {

		Map<String, Integer> words = new HashMap<String, Integer>();

		// Calling the function countEachWord
		//countEachWord("symptoms.txt", words);
          AnalyticsCounter counter = new AnalyticsCounter();
          counter.countEachWord("symptoms.txt", words);
		// Create a TreeMap
		Map<String, Integer> sortedWords = new TreeMap<>(words);

		// sorting the map
		sortedWords.entrySet().forEach(System.out::println);
		
		
		

		// Write in the java File
		
        //Determine the path
		Path path = Paths.get("text.txt");
		String texte = "Hellow Openclassrooms.\n I am very happy.\n";
		
		
		try {
			Files.write(path, texte.getBytes(), StandardOpenOption.CREATE, StandardOpenOption.WRITE,
					StandardOpenOption.APPEND);

		} catch (IOException e) {
			System.out.println("File does not exist");
			// e.printStackTrace();
		}

		// Read Files
		   ReadFile reader = new ReadFile();
		reader.readFile("symptoms.txt");

		
	}

}
