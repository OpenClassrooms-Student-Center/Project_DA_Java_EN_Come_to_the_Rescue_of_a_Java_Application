package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.TreeMap;

public class AnalyticsCounter {
	private static int headacheCount = 0; // initialize to 0
	private static int rashCount = 0; // initialize to 0
	private static int pupilCount = 0; // initialize to 0
	private static Object mapkey;
	private static Integer mapvalue;
	private static Boolean statut;
	// private static Object lignes;

	public static void main(String args[]) throws Exception {
		// first get input
		BufferedReader reader = new BufferedReader(new FileReader("symptoms.txt"));
		String line = reader.readLine();

		// writer2.write("symptom" + line + "\n");
		TreeMap treemapsymptom = new TreeMap<String, Integer>();
		mapkey = line;
		// statut = mapsymptom.containsKey(mapkey);
		// System.out.println("symptom existe-il from file: " + mapkey + statut);
		mapvalue = 0;
		// statut = mapsymptom.containsKey(mapkey);
		// mapsymptom.put(mapkey, mapvalue);
		// System.out.println("symptom existe-il from file: " + mapkey + statut);
		int i = 0; // set i to 0
		// FileWriter writer = new FileWriter("result.out");
		// FileWriter writer2 = new FileWriter("result2.out");
		// writer2.write("symptom" + line + "\n");

		while (line != null) {
			i++; // increment i
			System.out.println("symptom from file: " + line + " " + i);
			// mapkey = line;
			statut = false;
			// statut = mapsymptom.containsKey(mapkey);
			// if (statut = mapsymptom.containsKey(mapkey)) {
			if (statut = mapsymptom.containsKey(line)) {
				mapvalue++;
				// System.out.println("symptom existe1 from file: "+ mapsymptom.mapvalue()+
				// mapkey + statut).;
				System.out.println("symptom existe1 from file: " + mapvalue + " " + mapkey + statut);
				// mapsymptom.containsKey();
			} else {
				mapvalue++;
				mapkey = line;
				mapsymptom.put(mapkey, mapvalue);
				System.out.println("symptom inexistant from file: " + mapvalue + " " + mapkey + statut);

			}

			;
			System.out.println("symptom actuel from file: " + mapkey);
			FileWriter writermap = new FileWriter("resulta.out");
			writermap.write("headache: " + mapkey + " " + mapvalue + "  " + i + "\n");
			if (line.equals("headache")) {
				headacheCount++;
				System.out.println("number of headaches: " + headacheCount);
			} else if (line.equals("rash")) {
				rashCount++;
			} else if (line.contains("pupils")) {
				pupilCount++;
			}

			line = reader.readLine(); // get another symptom
			mapkey = line;
			// writer.write("symptom" + line + "\n");
		}
		if (line == null) {

			reader.close();
		}

		// String[] lignes=reader.readLine();
		// lignes=new String[]{"red","yellow", "orange", "green", "blue."};
		// for(String ligne:lignes) {ligne +;};

		// next generate output
		// Afficher le contenu du MAP

		FileWriter writer = new FileWriter("result.out");
		writer.write("headache: " + mapkey + " " + mapvalue + "  " + i + "\n");
		writer.write("headache: " + headacheCount + i + "\n");
		writer.write("headache: " + headacheCount + "\n");
		writer.write("rash: " + rashCount + "\n");
		writer.write("dialated pupils: " + pupilCount + "\n");
		writer.close();
		// writer.write("rash: " + rashCount + "\n");
		// writermap.close();
	}
}
