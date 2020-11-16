package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;// Package contenant la classe de gestion des exceptions
import java.util.ArrayList;// Package contenant la classe ArrayList
import java.util.List;// Package contenant la classe List
import java.util.Map;// Package contenant la classe Map (collection)
import java.util.TreeMap;// Package contenant la classe TreeMap (triée par ordre alphabétique)




public class AnalyticsCounter {  

	public static void main(String args[]) throws Exception { // first get input
	
	//dossier contenant les symptomes
	String docFile = "symptoms.txt";
	
	//liste des symptomes
    List<String>symptoms = new ArrayList<String>();
	
	
		
		if (docFile != null) {
			
			try {
				BufferedReader reader = new BufferedReader (new FileReader(docFile));
				
				String line = reader.readLine();
				
				while (line != null) {
					
					symptoms.add(line);
					
					line = reader.readLine();
				}
				reader.close();
				
				//permet de récupérer une éventuelle erreur d'exception. La méthode
				// "printStackTrace" permet d'afficher les lignes du code en erreur
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		//carte des symptomes
		Map<String,Integer>mapSym=new TreeMap<String,Integer>();
			
			for(String s :symptoms) {
				
			if(!mapSym.containsKey(s)) {
			
			mapSym.put(s,1);
			
			}else {
			 mapSym.put(s,mapSym.get(s)+1);
			
			 }
			
			}
			
		for(String key : mapSym.keySet()) {
			
		System.out.println( key +"="+ mapSym.get(key));
		
		}
			
    




       // next generate output
       FileWriter writer = new FileWriter ("result.out");
    
        writer.write(String.valueOf(mapSym));
       
        writer.close();
       

}
	}
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	/*public static int headCount = 0;	// initialize to 0
	private static int rashCount = 0;		// initialize to 0
	private static int pupilCount = 0;		// initialize to 0
	
	public static void main(String args[]) throws Exception {
		// first get input
		BufferedReader reader = new BufferedReader (new FileReader("symptoms.txt"));
		String line = reader.readLine();
		
		
		
		int headCount = 0;	// counts headaches
		
		while (line != null) {
			
			System.out.println("symptom from file: " + line);
			
			 
			
			if (line.equals("headache")) {
				headCount++;
				System.out.println("number of headache: " + headCount);
				
			}
			
			else if (line.equals("rash")) {
				rashCount++;
				System.out.println("number of rashs: "  + rashCount);
			}
			else if (line.equals("dialated pupils")) {
				pupilCount++;
				System.out.println("number of dialated pupils: "  + pupilCount);
			}
			 
			line = reader.readLine();// get another symptom
			 
			
		}
		
		// next generate output
		FileWriter writer = new FileWriter ("result.out");
		
		writer.write("dialated pupils: " + pupilCount + "\n");		
		writer.write("headache: " + headCount + "\n");
		writer.write("rash: " + rashCount + "\n");
		writer.close();
		reader.close();
	}
}*/