package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.TreeMap;

public class AnalyticsCounter {
	private static Object mapkey;
	private static Integer mapvalue;

	public static void main(String args[]) throws Exception {
		// first get input
		BufferedReader reader = new BufferedReader(new FileReader("symptoms.txt"));
		String line = reader.readLine();
		TreeMap treemapsymptom = new TreeMap<String, Integer>();
		mapkey = line;
		mapvalue = 0;
		int i = 0; // set i to 0

		while (line != null) {
			i++; // increment i

			if (treemapsymptom.containsKey(line)) {

				Integer mavaleur = (Integer) treemapsymptom.get(line);
				Integer neovaleur = Integer.valueOf(mavaleur.intValue() + 1);
				treemapsymptom.replace(line, neovaleur);
				mapvalue = neovaleur;
			} else {
				treemapsymptom.put(line, Integer.valueOf(1));
				mapvalue = Integer.valueOf(1);
			}

			line = reader.readLine(); // get another symptom
			mapkey = line;

		}
		if (line == null) {

			reader.close();
		}
		// next generate output
		// Afficher le contenu du MAP

		FileWriter writer = new FileWriter("result.out");
		// writermap.close();
		while (0 != treemapsymptom.size()) {
			// while (null != treemapsymptom.f()) {NoSuchElementException
			// System.out.println(
			// "symptom : " + treemapsymptom.firstKey() + " " +
			// treemapsymptom.get(treemapsymptom.firstKey()));
			writer.write("symptom : " + treemapsymptom.firstKey() + " " + treemapsymptom.get(treemapsymptom.firstKey())
					+ "\n");
			treemapsymptom.remove(treemapsymptom.firstKey());

		}
		writer.close();
	}
}
