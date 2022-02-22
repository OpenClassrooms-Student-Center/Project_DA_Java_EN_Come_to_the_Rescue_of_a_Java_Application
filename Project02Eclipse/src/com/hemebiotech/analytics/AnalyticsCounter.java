package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.List;
import java.util.ArrayList;

/**
 * to be filled later structure of javadoc
 * 
 * 
 */
public class AnalyticsCounter {
	/**
	 * to be filled later structure of javadoc produce what we want
	 * 
	 * @args blabla
	 */
	private static int headacheCount = 0; // to record the number of headache
	private static int rashCount = 0; // to record the number of rash
	private static int pupilCount = 0; // to record the number of pupil

	public static void main(String args[]) throws Exception {
		/**
		 * to be filled later structure of javadoc 
		 * produce what we want
		 * main steps: 1) read file (result: list of String)
		 * 2) counting:
		 * 2a) build empty list of Symptom (class with name and count)
		 * 2b) For each String from the list of String
		 * 2b-1) look for it in the list of Symptom
		 * 2b-1-a) if same symptom found : increase its count
		 * 2b-1-b) if not : insere new Symptom
		 * 3) write the result 
		 * 
		 * @args blabla
		 */

		// step 1: read file
//		ReadSymptomDataFromFile reader = new ReadSymptomDataFromFile("Project02Eclipse/symptoms.txt") ;
//		List<String> allSymptoms = reader.GetSymptoms() ;
		
		BufferedReader reader = new BufferedReader(new FileReader("Project02Eclipse/symptoms.txt"));
		String line = reader.readLine(); // first read line

		//step 2: counting
//		List<Symptom> countedSymptoms = new ArrayList<Symptom>() ;
//		for(String symptom : allSymptoms) {
//			addSymptomToList(symptom, countedSymptoms, 0)
//		}
		
		int i = 0; // counter for the lines of the file
		while (line != null) {
			i++;
			System.out.println("symptom from file: " + line);
			if (line.equals("headache")) {
				headacheCount++;
				System.out.println("number of headaches: " + headacheCount);
			} else if (line.equals("rash")) {
				rashCount++;
			} else if (line.contains("pupils")) {
				pupilCount++;
			}

			line = reader.readLine(); // get another symptom
		}

		// step 3: generate output
		FileWriter writer = new FileWriter("Project02Eclipse/result.out");
//		for(Symptom symptom : countedSymptoms) {
//			writer.write(symptom.name + "=" + symptom.count + "\n");
//		}
		writer.write("headache: " + headacheCount + "\n");
		writer.write("rash: " + rashCount + "\n");
		writer.write("dialated pupils: " + pupilCount + "\n");
		writer.close();
	}
	
	public void addSymptomToList(String symptom, List<Symptom> countedSymptoms, int index) {
		int sizeOfList = countedSymptoms.size();
		if(sizeOfList >= index) {
			countedSymptoms.add(new Symptom(symptom));
		} else {
			int diff = symptom.compareTo(countedSymptoms.get(index).name);
			if(diff==0) {
				countedSymptoms.get(index).count++;
			} else if(diff<0) { //symptom is before countedSymptoms.get(index).name
				countedSymptoms.add(index,new Symptom(symptom));
			} else { // symptom have to be inserted futher
				addSymptomToList(symptom, countedSymptoms, index+1);
			}
		}
	}
}
