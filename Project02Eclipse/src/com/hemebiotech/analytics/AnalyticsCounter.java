package com.hemebiotech.analytics;

import javafx.scene.effect.SepiaTone;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class AnalyticsCounter {
	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader (new FileReader("symptoms.txt"));
		String line = reader.readLine();
		Map<String, Integer> symptoms = new HashMap<>();

		while (line != null) {
			if (!symptoms.containsKey(line)) {
				symptoms.put(line, 1);
			} else {
				symptoms.put(line, symptoms.get(line) + 1);
			}
			line = reader.readLine();
		}
		String	str = "";
		Set<String>	keyset = symptoms.keySet();
		Iterator<String>	it = keyset.iterator();
		FileWriter writer = new FileWriter ("result.out");
		while (it.hasNext())
		{
			str = it.next();
			writer.write(str + " : " + symptoms.get(str) + "\n");
		}

		writer.close();
	}
}

