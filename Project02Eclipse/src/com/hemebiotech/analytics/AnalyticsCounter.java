package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.lang.Integer;

public class AnalyticsCounter {
	private static int headacheCount = 0;	// initialize to 0
	private static int rashCount = 0;		// initialize to 0
	private static int pupilCount = 0;		// initialize to 0
	private static int dryCount = 0;
	private static int inflamationCount = 0;
	private static int tremorCount = 0;
	private static int stomachCount = 0;

	
	public static void main(String args[]) throws Exception {
		// first get input
		BufferedReader reader = new BufferedReader (new FileReader("symptoms.txt"));
		String line = reader.readLine();
		
		// File file = new File ("symptoms.txt");
		/* int i = 0;	// set i to 0
		int headacheCount = 0;	// counts headaches */
		Map<String, Integer> map = new TreeMap<>();
		
		while (line != null) {
			int oldValue = (int) map.getOrDefault(line, 0);
			map.put(line,oldValue + 1);
			
			// i++;	// increment i
			System.out.println("symptom from file: " + line);
		
		
		
			// Scanner scanner = new Scanner(file);
			/* scanner.useDelimiter("[^a-zA-Z]"); // non alphabets act as delimeters
			String word = scanner.next();*/
			/* String fileContent = "";
			while(scan.hasNextLine()) {
				fileContent = fileContent.concat; */
			
			
			// System.out.println(scanner.nextLine());
			

			line = reader.readLine();	// get another symptom
		}
		
		// next generate output
		FileWriter writer = new FileWriter ("result.out");
		for(Map.Entry<String,Integer> entry : map.entrySet()) {
			  String key = entry.getKey();
			  Integer value = entry.getValue();

			  writer.write(key + ": " + value + "\n");
			}
		/* writer.write("headache: " + headacheCount + "\n");
		writer.write("rash: " + rashCount + "\n");
		writer.write("dialated pupils: " + pupilCount + "\n");
		writer.write("dry mouth: " + dryCount + "\n");
		writer.write("inflamation: " + inflamationCount + "\n");*/
		writer.close();
		
	}
}
