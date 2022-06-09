package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 
 * 
 * Dans cette classe SymptomReader nous allons une utiliser 2 méthodes, la
 * première produira une liste de personnes traité tandis que la seconde
 * determinera le nombre de symptomes existant.
 * 
 * @author El Ouaryaghli
 * @version 1.0
 * 
 */

public class SymptomReader {

	/**
	 * A partir du chemin du fichier source cette methode produit une ArrayList de
	 * chaine de caractère contenu, ligne par ligne, dans le fichier source. Dans
	 * cette méthode on lira ligne par ligne le contenu d'un fichier source situé
	 * dans le chemin "path". Puis on affectera les chaines de caractéres de chacune
	 * de ces lignes du fichier dans une List. Ainsi dans la List on aura une copie
	 * de tous les chaines de caractères avec toutes les redondances, ce qui nous
	 * permettra de connaître la totalité des lignes non vide sans avoir à utiliser
	 * un compteur mais en utilisant juste la méthode size(). Nous pourraons par la
	 * suite avoir accès aux information du fichier sans avoir à le lire de nouveau.
	 * 
	 * @param path Chemin d'accés du fichier source
	 * @return symptomesLst Liste des chaines de caractères qui peut contenir des
	 *         duplications
	 * @throws IOException Exception d'entrée/sortie (E/S) car on va lire un fichier
	 *                     qui pourrait ne pas exister
	 */

	public static List<String> ReadFiles(String path) throws IOException {

		List<String> symptomesLst = new ArrayList<String>(); // création d'un ensemble où sera repertorier tous les
																// symboles

		// Iterator<String> it = symptomes.iterator(); // itérateur pour obtenir les
		// éléments d'un ensemble

		FileReader fileReader = new FileReader(path); // Création d’un fileReader pour lire le fichier
		BufferedReader reader = new BufferedReader(fileReader);

		try {

			String line = reader.readLine(); // lecture de la ligne courante
			// et affectation de la donnée de cette ligne à la variable "line"
			while (line != null) {
				// symptomes.add(line); // remplissage de l'ensemble symptomes
				symptomesLst.add(line); // remplissage de la liste symptome
				line = reader.readLine(); // lecture de la prochaine ligne
			}
		} catch (

		IOException e) {
			e.printStackTrace();
		}
		reader.close(); // FIN DE LA LECTURE DU FICHIER

		return symptomesLst; // RETOUR DE LA LISTE DES SYMPTOMES QUI PEUT CONTENIR DES DUPLICATIONS
	}

	/**
	 * 
	 * A partir d'une liste de chaine de caractères fournit par une List cette
	 * methode produira un ensemble de chaine de caractère toute en éléminant les
	 * redondances présente dans la List.
	 * 
	 * 
	 * @param symptomesLst Liste des chaines de caractères qui peut contenir des
	 *                     duplications
	 * @return symptomes ensemble de chaine de caractères (il n'y a plus de
	 *         duplications).
	 */

	// CETTE METHODE NOUS PERMETTRA D'AVOIR UN ENSEMBLE CONTENANT LES SYMPTOMES SANS
	// REPETITION
	public static Set<String> symptomes(List<String> symptomesLst) {
		Set<String> symptomes = new HashSet<String>();
		for (int i = 0; i < symptomesLst.size(); i++) { // ON PARCOURS LA LISTE DES SYMPTOMES
			symptomes.add(symptomesLst.get(i)); // ON LES AFFECTE DANS UN ENSEMBLE
		}
		return symptomes; // RETOUR DE L'ENSEMBLE DE SYMPTOMES (IL N'Y A PLUS DE DUPLICATIONS)

	}

}
