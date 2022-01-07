package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Analyse une liste de String et stocke le résultat dans une liste d'objets
 * "Symptoms": symptomList
 */
public class AnalyticsCounter {

	ArrayList<Symptoms> symptomList = new ArrayList<Symptoms>();

	/**
	 * Constructeur de la classe AnalyticsCounter
	 * Elle définit la propriété symptomList qui est une liste d'objets "Symptoms"
	 * compte le nombre d'occurences et trie par ordre alphabétique.
	 * 
	 * @param rawlist Prends en paramètre une liste de String non triée.
	 * @see Symptoms
	 */
	public AnalyticsCounter(ArrayList<String> rawlist) {
		Collections.sort(rawlist); // trie la liste d'entrée par ordre alphabétique
		rawlist.add("Temporary"); // ligne temporaire à la fin de la liste
		ArrayList<Symptoms> symptomList = new ArrayList<Symptoms>(); // Déclaration de SymptomList: liste d'objets Symptoms
		try{
			for (int i = 1; i < rawlist.size(); i++) {

				if (!rawlist.get(i).equals(rawlist.get(i - 1))) { // Retourne "true" si la ligne a l'index i et différent de la ligne à l'index i-1
					Symptoms symptom = new Symptoms(rawlist.get(i - 1), rawlist); // si la condition est remplie, créée un objet de type Symptoms avec pour nom la ligne à l'index i-1
					symptomList.add(symptom); // ajoute le Symptom créé à Symptomlist
				}
			}
			System.out.println("Traitement "+ "\033[32m réussi"+ "\u001B[0m" );
		} catch (IndexOutOfBoundsException e){
			e.printStackTrace();
			System.out.println("\u001B[31m Erreur" +"\u001B[0m"+ " Impossible de générer une liste de symptomes");

		}
		rawlist.remove(rawlist.size() - 1); // Une fois la boucle terminée on supprime la ligne temporaire, cette ligne est facultative, mais plus propre au cas ou on aurait besoin d'une rawlist triée
		this.symptomList = symptomList; // On applique la sortie de la fonction à la variable globale symptomList
	}

	/**
	 * Méthode d'écriture de la propriété symptomList dans un fichier result.out
	 * 
	 * @throws IOException
	 */
	public void ResultGenerator() {

		try {
			FileWriter writer = new FileWriter("result.out"); // ouvre un writer et génère un fichier result.out
			for (int i = 0; i < symptomList.size(); i++) { // boucle sur symptomList
				writer.write(symptomList.get(i).GetName() + ": " + symptomList.get(i).GetOccurences() + "\n"); // Ecrit à chaque ligne "nom du symptome": "nombre d'occurences"
			}
			writer.close(); 
			System.out.println("Ecriture du fichier result.out"+ "\033[32m réussi"+ "\u001B[0m" );
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("\u001B[31mErreur" +"\u001B[0m"+ "Impossible de générer result.out");
		}
	}

	public ArrayList<Symptoms> GetList() {
		return this.symptomList;
	}

	public Symptoms GetIndex(int y) {
		return this.symptomList.get(y);
	}

}