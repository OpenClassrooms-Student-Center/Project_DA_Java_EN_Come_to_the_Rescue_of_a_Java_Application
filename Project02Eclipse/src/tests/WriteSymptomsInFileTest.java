package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import obj.ListSymptoms;
import obj.Symptom;
import util.ReadSymptomDataFromFile;
import util.WriteSymptomsInFile;

class WriteSymptomsInFileTest {

	public ListSymptoms makeList() {

		Symptom symptom1 = new Symptom("symptom1", 1);
		Symptom symptom2 = new Symptom("symptom2", 2);
		Symptom symptom3 = new Symptom("symptom3", 3);
		Symptom symptom4 = new Symptom("symptom4", 4);
		Symptom symptom5 = new Symptom("symptom5", 5);
		ListSymptoms listSymptoms = new ListSymptoms();
		listSymptoms.addNewSymptom(symptom1);
		listSymptoms.addNewSymptom(symptom2);
		listSymptoms.addNewSymptom(symptom3);
		listSymptoms.addNewSymptom(symptom4);
		listSymptoms.addNewSymptom(symptom5);

		return listSymptoms;
	}
	
	@Test
	void testWriteSymptoms() throws FileNotFoundException, IOException {
		
		String filePathOut = "./fichiers/tests/writeSymptoms.txt";

		File fileOut = new File(filePathOut);
//		fileOut.delete();
//		fileOut = new File(filePathOut);
	
		WriteSymptomsInFile writer = new WriteSymptomsInFile(filePathOut, makeList());
		
		// Expected
		List<String> listExpected = new ArrayList<String>();
		String symptom1String = "symptom1" + " : " + "1";
		listExpected.add(symptom1String);
		String symptom2String = "symptom2" + " : " + "2";
		listExpected.add(symptom2String);
		String symptom3String = "symptom3" + " : " + "3";
		listExpected.add(symptom3String);
		String symptom4String = "symptom4" + " : " + "4";
		listExpected.add(symptom4String);
		String symptom5String = "symptom5" + " : " + "5";
		listExpected.add(symptom5String);
		
		// Must be tested
		writer.writeSymptoms();
		ReadSymptomDataFromFile reader = new ReadSymptomDataFromFile(filePathOut);
		List<String> listTest = reader.GetSymptoms();
		
		// Check 
		assertEquals(listExpected, listTest);
		
	}

	@Test
	void testWriteSymptomsFileNotFound() {
		fail("Not yet implemented");
	}
}
