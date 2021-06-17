package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AnalyticsCounter {
	private static int count = 0;

	public static void main(String args[]) throws Exception {
		// first get input
		ReadSymptomDataFromFile reader = new ReadSymptomDataFromFile("Project02Eclipse/symptoms.txt");

		/**
		 * List of Symptoms
		 */
		List<String> symptomsList = reader.GetSymptoms();
		Set<String> symptoms = new HashSet<String>(symptomsList);
		List<String> symptomsUniq = new ArrayList<String>(symptoms);
		System.out.println(symptomsList);

		Collections.sort(symptomsUniq);
		System.out.println(symptomsUniq);
		FileWriter writer = new FileWriter("Project02Eclipse/result.out");
		try {
			for (int i = 0; i < symptomsUniq.size(); i++) {
				int occurrence = 0;
				for (int k = 0; k < symptomsList.size(); k++) {

					if (symptomsUniq.get(i).equals(symptomsList.get(k))) {
						occurrence++;
					}
				}
				System.out.println(symptomsUniq.get(i) + " : " + occurrence);
				writer.write(symptomsUniq.get(i) + " : " + occurrence +"\n");

			}
			writer.close();
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
