package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.TreeMap;

/**
 * Simple brute force implementation
 *
 */
public class ReadSymptomDataFromFile {

	// public ArrayList<String> result = new ArrayList<String>();

	public static String filepath;

	public static void main(String[] args) {

		String file = "C:\\Users\\aurel\\Documents\\JAVA OC\\P2\\ok\\symptoms.txt";

		System.out.println(getSymptomsWithoutDuplicate(file));
		System.out.println(getSymptomsWithDuplicate(file));
		System.out.println(getSymptomsRate(file));
		exportSymptomsRate(file);

	}

	/**
	 * ArrayList des maux sous forme de liste sans doublon
	 */

	public static ArrayList<String> getSymptomsWithoutDuplicate(String filepath) {

		ArrayList<String> result = new ArrayList<String>();

		if (filepath != null) {
			try {
				BufferedReader reader = new BufferedReader(new FileReader(filepath));
				String line = reader.readLine();

				while (line != null) {
					result.add(line);
					line = reader.readLine();
				}
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		ArrayList<String> resultClean = new ArrayList<String>(new HashSet<String>(result));

		Collections.sort(resultClean);

		return resultClean;
	}

	/**
	 * ArrayList des maux sous forme de liste avec doublon
	 */

	public static ArrayList<String> getSymptomsWithDuplicate(String filepath) {

		ArrayList<String> result = new ArrayList<String>();

		if (filepath != null) {
			try {
				BufferedReader reader = new BufferedReader(new FileReader(filepath));
				String line = reader.readLine();

				while (line != null) {
					result.add(line);
					line = reader.readLine();
				}
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		Collections.sort(result);

		return result;
	}

	/**
	 * Dictionnaire - HashMap clé(maux) et valeur(occurrence)
	 */

	public static Map<String, Integer> getSymptomsRate(String filepath) { // Pourquoi ça marche aussi avec Map au lieu
																			// de
																			// seulement marcher avec TreeMap
		ArrayList<String> result = new ArrayList<String>();

		if (filepath != null) {
			try {
				BufferedReader reader = new BufferedReader(new FileReader(filepath));
				String line = reader.readLine();

				while (line != null) {
					result.add(line);
					line = reader.readLine();
				}
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		int sommeMauxEnListe = result.size();
		Map<String, Integer> count = new TreeMap<String, Integer>();

		int i = 0;

		while (sommeMauxEnListe != 0) { // Evite les listes vides

			if (!count.containsKey(result.get(i))) { // Gère l'occurence maux dans la boucle

				count.put(result.get(i), i + 1);

			} else {
				int occurenceMoment = count.get(result.get(i));
				count.put(result.get(i), occurenceMoment + 1);
			}

			result.remove(i); // Retrait maux(i) dans result
			sommeMauxEnListe = result.size(); // Nouveau compte des éléments dans result

		}

		return count;
	}

	/**
	 * Export dans fichier result.out des maux en ordre alphabétique et de
	 * l'occurence de chaque maux
	 */

	public static void exportSymptomsRate(String filepath) {

		try {
			FileWriter writer = new FileWriter("result.out");
			int i = 0;
			while (getSymptomsWithoutDuplicate(filepath).size() - i != 0) {
				writer.write(getSymptomsWithoutDuplicate(filepath).get(i) + " : "
						+ getSymptomsRate(filepath).get(getSymptomsWithoutDuplicate(filepath).get(i)) + "\n");
				i = i + 1;
			}

//			writer.write(3); Pourquoi quand on met seulement 3 ou getSymptoms1(filepath).size() ça ne marche pas?

			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
