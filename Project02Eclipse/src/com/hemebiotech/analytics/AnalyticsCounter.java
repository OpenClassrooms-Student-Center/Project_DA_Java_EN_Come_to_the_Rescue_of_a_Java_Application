package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class AnalyticsCounter {

	ArrayList<Symptoms> symptomList = new ArrayList<Symptoms>();

	public AnalyticsCounter(ArrayList<String> rawlist) {
		Collections.sort(rawlist);
		rawlist.add("Temporary");
		ArrayList<Symptoms> symptomList = new ArrayList<Symptoms>();

		for (int i = 1; i < rawlist.size(); i++) {

			if (!rawlist.get(i).equals(rawlist.get(i - 1))) {
				Symptoms symptom = new Symptoms(rawlist.get(i - 1), rawlist);
				symptomList.add(symptom);
			}
		}
		rawlist.remove(rawlist.size()-1);
		System.out.println(rawlist);
		this.symptomList = symptomList;
	}

	public void ResultGenerator() throws IOException {

		FileWriter writer = new FileWriter("result.out");
		for (int i = 0; i < symptomList.size(); i++) {
			writer.write(symptomList.get(i).GetName() + ": " + symptomList.get(i).GetOccurences() + "\n");
		}
		writer.close();
	}

	public ArrayList<Symptoms> GetList() {
		return this.symptomList;
	}

	public Symptoms GetIndex(int y) {
		return this.symptomList.get(y);
	}

}
/**
 * 
 * private static int headCount = 0; // initialize to 0
 * private static int rashCount = 0; // initialize to 0
 * private static int pupilCount = 0; // initialize to 0
 * 
 * public static void main(String args[]) throws Exception { //Modifier cette
 * méthode en méthode de traitement
 * // Lire le fichier "symptoms.txt"
 * BufferedReader reader = new BufferedReader (new FileReader("symptoms.txt"));
 * String line = reader.readLine();
 * 
 * while (line != null) {
 * System.out.println("symptom from file: " + line);
 * if (line.equals("headache")) {
 * headCount++;
 * }
 * else if (line.equals("rash")) {
 * rashCount++;
 * }
 * else if (line.equals("dialated pupils")) {
 * pupilCount++;
 * }
 * 
 * line = reader.readLine(); // get another symptom
 * }
 * reader.close();
 * 
 * // next generate output
 * FileWriter writer = new FileWriter ("result.out");
 * writer.write("headache: " + headCount + "\n");
 * writer.write("rash: " + rashCount + "\n");
 * writer.write("dialated pupils: " + pupilCount + "\n");
 * writer.close();
 * }
 * 
 */
