package impl;

import java.util.List;

import obj.ListSymptoms;
import obj.Symptom;
import services.ISymptomsAnalyser;

public class AnalyseSymptomsFromList implements ISymptomsAnalyser {

	private List<String> liste;

	public AnalyseSymptomsFromList(List<String> liste) {
		this.liste = liste;
	}

	@Override
	public ListSymptoms AnalyseSymptoms() {
		// Map<String, Integer> treemap = new TreeMap<>();
		
		//si map ne contient pas élément => treemap.put(element, 1)
		//si map contient alors => je récupère mon élément et je fais +1
		// Je crée ma liste de symptomes vide
		ListSymptoms result = new ListSymptoms();

		// Je parcours ma liste de Strings lue
		for (String s : this.liste) {

			if (result.getListSymptoms().isEmpty()) {
				// liste vide : 1ère ligne (= comme pas trouvé)
				String nom = s; // Donc récupérer ligne lue
				Symptom symptomeAAjouter = new Symptom(nom, 1);
				result.addNewSymptom(symptomeAAjouter);
			} else {
				// liste pas vide
				Symptom symptomeCourant = result.searchInStringList(s);

				if (symptomeCourant != null) {
					// si trouvé
					result.increaseNumberOfSymptom(symptomeCourant);
				} else {
					// pas trouvé
					String nom = s; // Donc récupérer ligne lue
					Symptom symptomeAAjouter = new Symptom(nom, 1);
					result.addNewSymptom(symptomeAAjouter);
				}
			}
		}

		result.sort();

		return result;
	}

}
