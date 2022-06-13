package com.hemebiotech.analytics;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

/**
 * 
 * Cette classe permet de créer un fichier contenant la liste des symptômes 
 * avec le nombre de personnes qui les ont contracté. Cette liste est triée par ordre alphabétique
 */
public class SymptomOut {
	
	/**
	 * 
	 * @param map : Le tableau associant le nom d'un symptôme et le nombre de personne qui l'ont eu
	 */
	public static void editFinalFile(Map<String, Integer> map) {
	
	File resultOut = new File("Project02Eclipse/results.out.txt");
	
	// TreeMap permet de trier map par ordre alphabétique 
	Map<String, Integer> listmap = new TreeMap<String, Integer>(map);
	
	try(BufferedWriter writter = new BufferedWriter(new FileWriter(resultOut))){
		
		for (Entry<String, Integer> entry : listmap.entrySet()) { 
			String symptomName = entry.getKey();
			Integer numbers = entry.getValue(); 
			writter.write(symptomName + " = " + numbers + "\n"); //  
			
			}
			
			writter.close();
		
		} catch (IOException e) {
			e.printStackTrace();
		}
	
	}

}
