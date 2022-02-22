package com.hemebiotech.analytics;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

class ReadSymptomDataFromFileTest {

	@Test
	void testGetSymptoms() {
		String testingPath = "Project02Eclipse/symptoms.txt";
		ReadSymptomDataFromFile testReader = new ReadSymptomDataFromFile(testingPath);
		List<String> reading = testReader.GetSymptoms();
		assertEquals("fever", reading.get(0));
		assertEquals(100, reading.size());
	}

}
