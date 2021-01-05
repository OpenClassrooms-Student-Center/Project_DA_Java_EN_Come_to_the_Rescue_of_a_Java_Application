package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

public class AnalyticsCounter {
	private static int headacheCount = 0;
	private static int rashCount = 0;
	private static int pupilCount = 0;
	private static int another = 0; // ajout d'une constante pour conpter le nombre d'autre symptomes

	public static void main(String args[]) throws Exception {
		// first get input
		BufferedReader reader = new BufferedReader(new FileReader("Project02Eclipse/Symptoms.txt"));
		String line = reader.readLine();

		while (line != null) { // permet de verifier que la variable "line" n'est pas nulle
			System.out.println("symptom from file: " + line);
			if (line.equals("headache")) {
				headacheCount++;
				System.out.println("number of headaches: " + headacheCount);
			} else if (line.equals("rash")) {
				rashCount++;
			} else if (line.contains("pupils")) {
				pupilCount++;
			} else { // Ajout de "else" afin de finaliser l'instruction else if et compter le nombre
						// de symtomes non traités
				another++;
			}

			line = reader.readLine(); // get another symptom
		}
		reader.close();

		// next generate output
		FileWriter writer = new FileWriter("result.out");
		writer.write("headache: " + headacheCount + "\n");
		writer.write("rash: " + rashCount + "\n");
		writer.write("dialated pupils: " + pupilCount + "\n");
		writer.write("another symptoms : " + another + "\n"); // Ajout d'une ligne d'écriture afin de remonter le nombre
																// d'autre symptomes non traités
		writer.close();
	}
}
