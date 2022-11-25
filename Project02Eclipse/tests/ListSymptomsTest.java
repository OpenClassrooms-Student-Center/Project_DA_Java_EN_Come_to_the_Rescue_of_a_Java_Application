package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import obj.ListSymptoms;
import obj.Symptom;

class ListSymptomsTest {

	@BeforeAll
	public static ListSymptoms makeList() {

		Symptom symptom1 = new Symptom("symptom1", 1);
		Symptom symptom2 = new Symptom("symptom2", 2);
		Symptom symptom3 = new Symptom("symptom3", 3);
		Symptom symptom4 = new Symptom("symptom4", 4);
		Symptom symptom5 = new Symptom("symptom5", 5);
		ListSymptoms listSymptoms = new ListSymptoms();
		listSymptoms.addNewSymptom(symptom5);
		listSymptoms.addNewSymptom(symptom2);
		listSymptoms.addNewSymptom(symptom4);
		listSymptoms.addNewSymptom(symptom1);
		listSymptoms.addNewSymptom(symptom3);

		return listSymptoms;
	}

	@Test
	void testSearchInStringListFound() {

		ListSymptoms listSymptoms = makeList();

		String nameOfSymptomToFind = "symptom1";

		assertEquals(listSymptoms.getListSymptoms().get(3), listSymptoms.searchInStringList(nameOfSymptomToFind));

	}

	@Test
	void testSearchInStringListNotFound() {

		ListSymptoms listSymptoms = makeList();

		String nameOfSymptomToFind = "symptomX";

		assertEquals(null, listSymptoms.searchInStringList(nameOfSymptomToFind));

	}

	@Test
	void testSearchInStringListEmpty() {

		ListSymptoms listSymptoms = new ListSymptoms();

		String nameOfSymptomToFind = "symptom1";

		assertEquals(null, listSymptoms.searchInStringList(nameOfSymptomToFind));

	}

	@Test
	void testAddNewSymptom() {

		ListSymptoms listSymptomsExpected = makeList();
		ListSymptoms listSymptoms = makeList();
		Symptom symptom6 = new Symptom("symptom6", 6);

		listSymptomsExpected.getListSymptoms().add(symptom6);

		listSymptoms.addNewSymptom(symptom6);

		for (int i = 0; i < listSymptomsExpected.getListSymptoms().size(); i++) {
			assertEquals(listSymptomsExpected.getListSymptoms().get(i), listSymptoms.getListSymptoms().get(i));
		}

	}

	@Test
	void testIncreaseNumberOfSymptom() {

		Symptom symptom1 = new Symptom("symptom1", 1);
		Symptom symptom2 = new Symptom("symptom2", 1);
		Symptom symptom3 = new Symptom("symptom3", 3);
		Symptom symptom4 = new Symptom("symptom4", 4);
		Symptom symptom5 = new Symptom("symptom5", 5);
		ListSymptoms listSymptoms = new ListSymptoms();
		listSymptoms.addNewSymptom(symptom5);
		listSymptoms.addNewSymptom(symptom2);
		listSymptoms.addNewSymptom(symptom4);
		listSymptoms.addNewSymptom(symptom1);
		listSymptoms.addNewSymptom(symptom3);

		listSymptoms.increaseNumberOfSymptom(symptom2);

		assertEquals(2, listSymptoms.getListSymptoms().get(1).getOccurences());
	}

	@Test
	void testSort() {

		Symptom symptom1 = new Symptom("symptom1", 1);
		Symptom symptom2 = new Symptom("symptom2", 2);
		Symptom symptom3 = new Symptom("symptom3", 3);
		Symptom symptom4 = new Symptom("symptom4", 4);
		Symptom symptom5 = new Symptom("symptom5", 5);

		ListSymptoms listSymptomsExcpected = new ListSymptoms();
		listSymptomsExcpected.addNewSymptom(symptom1);
		listSymptomsExcpected.addNewSymptom(symptom2);
		listSymptomsExcpected.addNewSymptom(symptom3);
		listSymptomsExcpected.addNewSymptom(symptom4);
		listSymptomsExcpected.addNewSymptom(symptom5);

		ListSymptoms listSymptoms = makeList();
		listSymptoms.sort();

		for (int i = 0; i < listSymptomsExcpected.getListSymptoms().size(); i++) {
			assertEquals(listSymptomsExcpected.getListSymptoms().get(i), listSymptoms.getListSymptoms().get(i));
		}

	}

}
