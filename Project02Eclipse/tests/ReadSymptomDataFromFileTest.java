package tests;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import util.ReadSymptomDataFromFile;

class ReadSymptomDataFromFileTest {

	@Test
	void testGetSymptoms() throws FileNotFoundException {

		List<String> listExpected = new ArrayList<String>();
		listExpected.add("Symptom1 : 1");
		listExpected.add("Symptom2 : 2");
		listExpected.add("Symptom3 : 3");
		listExpected.add("Symptom4 : 4");
		
		String fileTestGetSymptoms = "./fichiers/tests/getSymptoms.txt";
		
		ReadSymptomDataFromFile reader = new ReadSymptomDataFromFile(fileTestGetSymptoms);
		
		assertEquals(listExpected, reader.GetSymptoms());
	}
	
	@Test
	void testGetSymptomsFileNotFound() {

		String fileNotFound = "./fichiers/tests/filexxxx.txt";
		
		ReadSymptomDataFromFile reader = new ReadSymptomDataFromFile(fileNotFound);
		
		assertThrows(FileNotFoundException.class, () -> reader.GetSymptoms());
		
	}
	
	@Test
	void testGetSymptomsEmptyFile() throws FileNotFoundException {
		
		List<String> listExpected = new ArrayList<String>();
		
		String fileTestGetSymptoms = "./fichiers/tests/getSymptomsEmptyFile.txt";

		ReadSymptomDataFromFile reader = new ReadSymptomDataFromFile(fileTestGetSymptoms);
		
		assertEquals(listExpected, reader.GetSymptoms());
	}
	
}
