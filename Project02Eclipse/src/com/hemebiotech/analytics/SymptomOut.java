package com.hemebiotech.analytics;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.Map.Entry;

import com.hemebiotech.interfaces.IOutFile;

import java.util.TreeMap;

/**
 * 
 * Cette classe permet de créer un fichier contenant la liste des symptômes 
 * avec le nombre de personnes qui les ont contracté. Cette liste est triée par ordre alphabétique
 */
public class SymptomOut implements IOutFile {
	

	public void editFinalFile(Map<String, Integer> map) {
	
	File resultOut = new File("Project02Eclipse/results.out.txt");
	
	// TreeMap permet de trier map par ordre alphabétique 
	Map<String, Integer> ordermap = new TreeMap<String, Integer>(map);
	
	try(BufferedWriter writter = new BufferedWriter(new FileWriter(resultOut))){
		
		for (Entry<String, Integer> entry : ordermap.entrySet()) { 
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
