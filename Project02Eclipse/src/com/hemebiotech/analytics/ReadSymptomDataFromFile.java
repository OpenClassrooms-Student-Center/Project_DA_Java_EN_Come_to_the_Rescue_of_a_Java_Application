package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
//import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

/**
 * Class representing to read data from a file on disk.
 * 
 * @author aurelen.ndjamba @version 1.0
 *
 */
public class ReadSymptomDataFromFile implements ISymptomReader {
	
	/**
	 * If no data is available, return an empty List
	 * 
	 * @return a raw listing of all Symptoms obtained from a data source, duplicates
	 *         are possible/probable
	 *         
	 * @param filepath
	 */
	@Override
	public ArrayList<String> getSymptomsWithDuplicate(String filepath) {

		ArrayList<String> listSymptomWithDuplicat = new ArrayList<String>();

		if (filepath != null) {
			
			try {
				BufferedReader reader = new BufferedReader(new FileReader(filepath));
				String line = reader.readLine();

				while (line != null) {
					listSymptomWithDuplicat.add(line.toLowerCase()); // Convertion en minuscule puis ajout des maux dans la liste.
					line = reader.readLine();
				}
				reader.close();
			} 
			catch (FileNotFoundException e) {
				System.out.println("the named file does not exist");
			} 
			catch (IOException e) {
				e.printStackTrace();
			} 
			finally {
//				reader.close();  -> Renvoi un message d'erreur dans le bloc finally
			}
		}

		return listSymptomWithDuplicat;
	}

	/**
	 * If no data is available, return an empty Map
	 * 
	 * @return a dictionary of all the symptoms obtained from a data source in the
	 *         <b> format: { key (symptom): value (occurrence) } </b>. Duplicates
	 *         are not possible/probable
	 *         
	 * @param listSymptomWithDuplicat
	 */
	@Override
//	public Map<String, Integer> getSymptomsRate(ArrayList<String> listSymptomWithDuplicat) {
//
//		
//		int sumSymptomWithDuplicat = listSymptomWithDuplicat.size(); 
//		Map<String, Integer> SymptomsRate = new TreeMap<String, Integer>(); 
//
//		int i = 0;
//
//		while (sumSymptomWithDuplicat != 0) { // Evite les fichiers de symptoms sans maux (vide)
//
//			if (SymptomsRate.containsKey(listSymptomWithDuplicat.get(i))) { // Gère l'occurence maux dans la boucle
//
//				int occurenceMoment = SymptomsRate.get(listSymptomWithDuplicat.get(i));
//				SymptomsRate.put(listSymptomWithDuplicat.get(i), occurenceMoment + 1);
//
//			} else {
//
//				SymptomsRate.put(listSymptomWithDuplicat.get(i), 1);
//			}
//
//			listSymptomWithDuplicat.remove(i); // Retrait maux(i) dans result
//			sumSymptomWithDuplicat = listSymptomWithDuplicat.size(); // Nouveau compte des éléments dans result
//
//		}
//
//		return SymptomsRate;
//	}
	
public Map<String, Integer> getSymptomsRate(ArrayList<String> listSymptomWithDuplicat) {

		Map<String, Integer> SymptomsRate = new TreeMap<String, Integer>(); 

		for (String n : listSymptomWithDuplicat) {
			if (SymptomsRate.containsKey(n)) { // Gère l'occurence maux dans la boucle

				int occurenceMoment = SymptomsRate.get(n);
				SymptomsRate.put(n, occurenceMoment + 1);

			} else {

				SymptomsRate.put(n, 1);
			}
		}
		
		return SymptomsRate;

	//
}
}