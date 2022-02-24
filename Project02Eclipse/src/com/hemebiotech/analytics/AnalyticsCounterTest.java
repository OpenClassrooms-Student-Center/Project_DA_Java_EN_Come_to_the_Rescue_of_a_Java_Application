package com.hemebiotech.analytics;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class AnalyticsCounterTest {

	@Test
	void testAddSymptomToList() {
		AnalyticsCounter testAnalyticsCounter = new AnalyticsCounter();
		Symptom sympA = new Symptom("a");
		Symptom sympB = new Symptom("b");
		Symptom sympC = new Symptom("c");
		List<Symptom> countedSymptoms = new ArrayList<Symptom>();
		countedSymptoms.add(sympA);
		countedSymptoms.add(sympB);
		countedSymptoms.add(sympC);

		testAnalyticsCounter.addSymptomToList("b", countedSymptoms);
		assertEquals(2, countedSymptoms.get(1).count);

		testAnalyticsCounter.addSymptomToList("ab", countedSymptoms);
		assertEquals("ab", countedSymptoms.get(1).name);

		testAnalyticsCounter.addSymptomToList("d", countedSymptoms);
		assertEquals(5, countedSymptoms.size());
	}

}
