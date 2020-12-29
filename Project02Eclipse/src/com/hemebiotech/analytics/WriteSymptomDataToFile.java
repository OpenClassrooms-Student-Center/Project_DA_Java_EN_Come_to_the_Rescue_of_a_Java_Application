package com.hemebiotech.analytics;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;





/**
 * @author fouziahajji
 * La classe WriteSymptomDataToFile permet de récupérer une Map et d'écrire ses résultats par ordre alphabétique
 * dans le fichier de sortie.
 */
public class WriteSymptomDataToFile implements ISymptomWriter{
	
		private String fileOutPut;
	
	    /**Constructors
	    *
	    */
		public WriteSymptomDataToFile (String fileOutPut) {
			this.fileOutPut = fileOutPut;
			
		}

	     /**La methode writeSymptoms ecrit le resultat dans une fichier en parcourant la Map symptoms
	     *@param map
	     *@throws IOException
	     */
		@Override
	    public void writeSymptoms(Map<String, Integer> map) throws IOException {
	    	
	    	
	
	         if ((fileOutPut != null) && (map != null)) {
	                // Parcoure la Map pour écrire les symptômes dans le fichier
	                try {
	                    BufferedWriter writer = new BufferedWriter(new FileWriter(fileOutPut));
	                    for (Map.Entry<String, Integer> symptom : map.entrySet()) {
	                        writer.write(symptom.getKey() + " = " + symptom.getValue() + "\n");
	                    }
	                    writer.close();
	                } catch (IOException e) {
	                    e.printStackTrace();
	                    
	                    
	                }
	            }
	        }
		
	    


}



