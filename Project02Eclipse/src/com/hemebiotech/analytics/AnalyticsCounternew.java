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

	@Override
	// Definir la méthode qui récupère la liste des symptoms
	public List<String> getSymptoms(String fileName) {
		ArrayList<String> result = new ArrayList<String>();
		if (fileName != null) {
			try {
				// Créer l'object fileReader
				FileReader fileReader = new FileReader(fileName);
				// Créer l'object reader
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
