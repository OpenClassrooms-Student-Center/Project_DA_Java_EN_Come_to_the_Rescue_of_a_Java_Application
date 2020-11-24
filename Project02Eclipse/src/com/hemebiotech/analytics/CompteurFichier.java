package com.hemebiotech.analytics;



import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;




public class CompteurFichier {

	  public static void main(String[] args) throws IOException{
		  
		  
	    
		  
		  ArrayList<String> symptoms = new ArrayList<>();
		  
		
		  //Pour lire un fichier "symptoms.txt"
		  BufferedReader reader = new BufferedReader(new FileReader("symptoms.txt")); 
		      while (reader.ready()) {
		    	  symptoms.add(reader.readLine());
		    	  
		    
		      }  
		      reader.close();
	         
	      //Cette table de hashage contiendra les occurences des symptoms
		  HashMap<String,Integer> occurencesDesSymptoms = new HashMap<String, Integer>();
		  
		  
	        
	      //On itère sur le tableau des symptoms.
	      for (int i = 0, c = symptoms.size(); i< c; i++) {
	            //On récupère le symptom
	            String symptom = symptoms.get(i);
	            //On regarde si le symptom est déjà présent dans la table d'occurence.
	            if (occurencesDesSymptoms.containsKey(symptom)) {
	            //Le symptom est présent dans la table d'occurence, on incrémente l'occurence de 1.
	                occurencesDesSymptoms.put(symptom, occurencesDesSymptoms.get(symptom) + 1);
	            } else {
	            //Le symptom n'est pas présent dans la table d'occurence, on insère la note dans la table et on met l'occurence à 1.   
	                occurencesDesSymptoms.put(symptom, 1);
	            }
	            
	            
	            
	        } 
	         
	        //On affiche le résultat, c'est à dire les occurences des symptoms.
	        
//	        Set<Entry<String, Integer>> entrySet = occurencesDesSymptoms.entrySet();
//	        for (Entry<String, Integer> entry : entrySet) {
//	        	
//	        	
//	            System.out.println(entry.getKey()+" = "+entry.getValue());         
//	        }
	      
	      
	      occurencesDesSymptoms.entrySet().stream() 
	      .sorted(Map.Entry.<String, Integer>comparingByKey() ) 
	      .forEach(System.out::println);
	  
		 
		    
		     
		          
	      //On ecrit le resultat dans le fichier "result.txt".
	      
	      
		    
	        try {
	        	
	        	FileWriter writer = new FileWriter ("result.out");
				for (Map.Entry<String, Integer> entry : occurencesDesSymptoms.entrySet()) {
					writer.write(entry.getKey().toString() + " = " + entry.getValue().toString() + "\n");
					writer.flush();
				}
				
				
		        writer.close();
		        
	        } catch (IOException e) {
				e.printStackTrace();
			}
		        	  
		
	  
		  
	    }
	  
	  
	  

	} 


