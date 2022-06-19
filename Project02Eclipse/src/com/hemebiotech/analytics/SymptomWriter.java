package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

/**
 * 
 * 
 * 
 * 
 * Dans cette classe SymptomWriter nous allons une méthode qui produira un
 * fichier dans lequel il est retranscri le contenu du dictionnaire.
 * 
 * 
 * 
 * 
 * @author El Ouaryaghli
 * @version 1.0
 * 
 */

public class SymptomWriter {

	/**
	 * Après avoir renseigné le chemin avec que le nom du fichier résultat et après
	 * avoir instancié le dictionnaire à retranscrire, cette methode produit un
	 * fichier avec le contenu du dicttionnaire.
	 * 
	 * 
	 * @param path         Chemin d'accés du fichier à produire
	 * 
	 * @param symptomeNbre Dictionnaire de clé, valeur : String , Integer.
	 * 
	 * @throws IOException Exception d'entrée/sortie (E/S) car on va écrire dans un
	 *                     fichier qui pourrait ne pas exister
	 * 
	 * 
	 */

	public static void CreatFiles(String path, Map<String, Integer> symptomeNbre) throws IOException {

		FileWriter writer = new FileWriter(path); // génération du fichier dans le chemin renseigner

		for (Map.Entry<String, Integer> entry : symptomeNbre.entrySet()) // on parcours le dictionnaire
		{
//			printEntry(entry); // on affiche l'ensemble de son contenu

			try {
				writer.write("There is " + entry.getValue() + " " + entry.getKey() + "\n"); // écriture dans le fichier
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		writer.close();

	}

	// methode permettant d'afficher une entrée d'un dictionnaire
//	private static void printEntry(Map.Entry entry) {
//		System.out.println(entry.getKey() + " -> " + entry.getValue());
//
//	}

}
