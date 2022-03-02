package test.com.hemebiotech.analytics;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import com.hemebiotech.analytics.AnalyticsCounter;
import com.hemebiotech.analytics.Symptom;

class AnalyticsCounterTest {

	@Test
	void testRecursiveAddSymptomToList() {
		AnalyticsCounter testAnalyticsCounter = new AnalyticsCounter();
		Symptom sympA = new Symptom("a");
		Symptom sympB = new Symptom("b");
		Symptom sympC = new Symptom("c");
		List<Symptom> countedSymptoms = new ArrayList<Symptom>();
		countedSymptoms.add(sympA);
		countedSymptoms.add(sympB);
		countedSymptoms.add(sympC);

		testAnalyticsCounter.recursiveAddSymptomToList("b", countedSymptoms, 0);
		assertEquals(2, countedSymptoms.get(1).count);

		testAnalyticsCounter.recursiveAddSymptomToList("ab", countedSymptoms, 0);
		assertEquals("ab", countedSymptoms.get(1).name);

		testAnalyticsCounter.recursiveAddSymptomToList("d", countedSymptoms, 0);
		assertEquals(5, countedSymptoms.size());
	}

}
