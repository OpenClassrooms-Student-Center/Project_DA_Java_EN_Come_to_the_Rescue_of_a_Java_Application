
package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;





/**
 * La classe AnalyseSymptom permet de lire une Arraylist de symptoms, de compter ces symptoms de les recenser par ordre alphabétique 
 * et d'ecrire le resultat dans un fichier.
 * @author fouziahajji
 */
public class AnalyseSymptom extends Analyse implements ISymptomReader, ISymptomWriter{
	
	private String filepath;
	private String fileOutPut;	
	
    /**Constructors
     *
    */
	public AnalyseSymptom(String filepath, String fileOutPut) {
		this.filepath = filepath;
        this.fileOutPut = fileOutPut;        
	}

	/**La méthode getSymptoms recupere la liste des symptoms depuis un fichier source et les integre dans une ArrayList
	 * @return tabSymptom
	 */
	public ArrayList<String> getSymptoms() {
		ArrayList<String> tabSymptom = new ArrayList<String>();
		
		if (filepath != null) {
			try {
				BufferedReader reader = new BufferedReader (new FileReader(filepath));
				String line = reader.readLine();
				
				while (line != null) {
					tabSymptom.add(line);
					line = reader.readLine();
				}
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return tabSymptom;
		
		
	}

	/**La methode countSymptoms recupere une liste de symptoms et les integre dans une TreeMap afin de les recenser par ordre alphabétique
	 * ensuite compte le nombre d'occurences pour chaque symptoms
	 * @param ArrayList list
	 * @return ListOccurences
	 */
	public TreeMap<String, Integer> countSymptoms(ArrayList<String> list) {
		  
		
		
		//Utilisation de treemap pour trier la map par ordre alphabétique
		TreeMap<String, Integer> ListOccurences = new TreeMap<String, Integer>();
	  
	 
		//On itère sur le tableau des symptoms.
		for (String symptom: list) {
				//On regarde si le symptom est déjà présent dans la table d'occurence.
				if (ListOccurences.containsKey(symptom)) {
					//Le symptom est présent dans la table d'occurence, on incrémente l'occurence de 1.
					ListOccurences.put(symptom, ListOccurences.get(symptom) + 1);
				} else {
					//Le symptom n'est pas présent dans la table d'occurence, on insère la note dans la table et on met l'occurence à 1.   
					ListOccurences.put(symptom, 1);
				}
	    
				
		} 
			//On affiche le résultat, c'est à dire les occurences des symptoms classés par ordre alphabétique.
      		ListOccurences.entrySet().forEach(System.out::println);
	      
      		return ListOccurences;
	  
		  
	  }
	/**La methode writeSymptoms ecrit le resultat dans une fichier en parcourant la Map symptoms
	 * @throws IOException
	 */
    public void writeSymptoms(Map<String,Integer> map) throws IOException {
    	
    	
    	
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
        System.out.println("le resultat se trouve dans le fichier: " + fileOutPut);
    	
       }
    

    
	  
	

}

    

    
	  
	



