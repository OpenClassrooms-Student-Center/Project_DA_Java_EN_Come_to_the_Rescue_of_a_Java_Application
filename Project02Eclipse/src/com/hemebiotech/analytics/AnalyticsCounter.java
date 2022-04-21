package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/*
public class AnalyticsCounter {
	public static void main(String args[]) throws Exception {
		// first get input
		BufferedReader reader = new BufferedReader (new FileReader("symptoms.txt"));
		String line = reader.readLine();

		int i = 0;	// set i to 0
		while (line != null) {
			i++;	// increment i
			System.out.println("symptom from file: " + line);
			if (line.equals("headache")) {
				headCount++;
				System.out.println("number of headaches: " + headCount);
			}
			line = reader.readLine();	// get another symptom
		}
		
		// next generate output
		FileWriter writer = new FileWriter ("result.out");
		writer.write("headache: " + headacheCount + "\n");
		writer.close();
	}
}
*/

public class AnalyticsCounter {
	public static void main(String args[]) throws Exception {
		// first get input
		BufferedReader reader = new BufferedReader (new FileReader("symptoms.txt"));
		String line = reader.readLine();
		int	i = 0;
		int j = 0;
		boolean t = false;
		Map<String, Integer> symptoms = new HashMap<String, Integer>();

		while (line != null) {
			if (symptoms.containsKey(line) == false) {
				symptoms.put(line, 1);
			}
			else {
				System.out.println("Le mot existe deja");
				j = symptoms.get(line);
				symptoms.put(line, j+1);
				/* La valeur integrer correspondant a la clé de cette ligne soit egale a la valeur actuelle +1*/
			}
			j = 0;
			line = reader.readLine();	// get another symptom
		}

		// next generate output
		FileWriter writer = new FileWriter ("result.out");
		writer.write(symptoms + "\n");
		writer.close();
	}
}

