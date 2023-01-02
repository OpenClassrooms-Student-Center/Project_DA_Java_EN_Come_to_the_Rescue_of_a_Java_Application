package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class AnalyticsCounternew implements IAnalyticsCounternew {

	// Constructeur par défaut

	public AnalyticsCounternew() {
		super();

	}

	/**
	 * Méthode pour récupèrer la liste des symptomes.
	 * <p>
	 * Cette méthode sert à lire le fichier symptoms.txt ligne par ligne et les
	 * stocker dans la liste result . le Try catch utilise dans cette méthode permet
	 * de gérer les exceptions.
	 * <p>
	 * 
	 * @param fileName le nom de fichier symptoms.txt.
	 * @return la liste des symptoms stocker dans la liste result.
	 */
	@Override
	// Définir la méthode qui récupère la liste des symptoms
	public List<String> getSymptoms(String fileName) {
		ArrayList<String> result = new ArrayList<String>();
		if (fileName != null) {
			try {
				// une fonction à essayer pouvant générer une erreur
				// Créer l'object fileReader pour lire le fichier
				FileReader fileReader = new FileReader(fileName);
				// Créer l'object reader qui utilise le fileReader
				BufferedReader reader = new BufferedReader(fileReader);
				// Lire le contenu du fichier
				String line = reader.readLine();
				while (line != null) {
					// Ajouter le contenu de line à l'object result
					result.add(line);
					line = reader.readLine();
				}
				reader.close();
			} catch (IOException e) {

				e.printStackTrace();

			}
		}
		return result;

	}

	/**
	 * Méthode pour calculer l'occurence de chaque symptoms et les trier par ordre
	 * alphabétique.
	 * <p>
	 * Cette méthode sert à calculer l'occurence de chaque symptome. Cette occurence
	 * est calculé en utilisant l'interface Map, la clé c'est le nom de symptome et
	 * la valeur c'est son occurence. la classe TreeMap permet de trier les symptoms
	 * dans l'ordre alphabétique.
	 * <p>
	 * 
	 * @param listSymptoms la liste des symptomes.
	 * @return mapResult qui prend en clé le nom de symptome et en valeur son
	 *         occurence trier par ordre alphabétique.
	 */
	@Override
	// Definir la méthode qui regroupe le symptom par occurence
	public Map<String, Integer> getSymptomsMapOcurence(List<String> listSymptoms) {
		Map<String, Integer> mapResult = new TreeMap<>();
		int i = 1;
		// Parcourir la liste listSymptoms et la stocker dans la liste symptom
		for (String symptom : listSymptoms) {
			// Vérifier si la valeur recuperer de symptom sans compter les espaces est diff
			// de null
			if (mapResult.get(symptom.trim()) != null) {
				// Placer la valeur de mapResult dans oldOcurence
				Integer oldOcurence = mapResult.get(symptom);
				// Incrémenter oldOcurence
				Integer newOcurence = oldOcurence + 1;
				mapResult.replace(symptom.trim(), newOcurence);
			} else {
				mapResult.put(symptom.trim(), i);
			}

		}
		return mapResult;
	}

	/**
	 * Méthode pour écrire le resultat dans le fichier result.out.
	 * <p>
	 * Cette méthode sert à écrire dans le fichier result.out. le Try catch utilise
	 * dans cette méthode permet de gérer les exceptions. FileWriter pour écrire
	 * dans le fichier Utiliser la boucle for Each pour parcourir le Map
	 * symptomsOcurenceMap.
	 * <p>
	 * 
	 * @param fileNameOut le nom de fichier result.out
	 * @param symptomsOcurenceMap les noms des symptomes avec leurs occurences.  
	 * @return fichier result.out.
	 */
	@Override
	// definir la méthode qui écrire dans le fichier result.out
	public void writerSymptoms(Map<String, Integer> symptomsOcurenceMap, String fileNameOut) throws IOException {

		try {
			File fichier = new File(fileNameOut);

			FileWriter writer = new FileWriter(fichier);
			// Parcourir Map symptomsOcurenceMap
			for (Map.Entry<String, Integer> entry : symptomsOcurenceMap.entrySet())

			{

				writer.write(entry.getKey() + ":" + entry.getValue() + "\n");
				writer.flush();
			}
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
