package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hemebiotech.services.ISymptomWriter;

public class WriteSymptomDataToFile implements ISymptomWriter  {
	
	private List<String> file;
	
	public WriteSymptomDataToFile(List<String> file) {
		this.file = file;
	}

	/*implementation de l'interface 
	writeSymptoms*/
	
	@Override
	public Map<String, Integer> writeSymptoms() {
		
		/*notre hasmap qui va nous permettre de collecter les informations
		du fichier txt et les ranger part clé valeur.*/
		Map<String, Integer> writeSymptomsFromFile = new HashMap<String, Integer>();
		
		if(this.file != null) {
			
			try {
					FileWriter writer = new FileWriter("disease.txt");
					
					/* On creer une boucle for imbriqué afin de pouvoir compter le nombree
					 * d'iteration de chaque maladie la premiere compte le nombre d'element du fichier la deuxieme
					 * traite le nb de fois que chaque élément réaparait 
					 */
					
					for( int i = 0; i <= file.size()-1; i++) {
							int count = 0;
						for(String symptom : file) {
							if (symptom.contains(file.get(i))) {
								count++;
								writeSymptomsFromFile.put(symptom, count);
							}
						}
					}
					
					/* on utilise une expression lamba afin de boucler sur tout les elem du tableau valorisé K,V 
					 *  on ecrit le tout dans le fichier txt*/
					
					writeSymptomsFromFile.forEach((value,key) -> {try {
						writer.write( " " + key + " " + value + "\r");
					} 
					catch (IOException e) {
						e.printStackTrace();
					};});
					writer.close();
					System.out.println("Successfully wrote text to file.");
				
			} catch (Exception e) {
				e.printStackTrace();
				System.err.println(" oops!! Something went wrong");
			}
		}
		return writeSymptomsFromFile;
	}
}