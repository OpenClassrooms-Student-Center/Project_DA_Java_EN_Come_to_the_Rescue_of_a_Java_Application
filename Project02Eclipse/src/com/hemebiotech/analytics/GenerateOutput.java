package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

public class GenerateOutput implements ISymptomWriter {

	static final String outPutFile = "result.out";

	public void writeSymptoms(Map<String, Integer> compteurs) {
		try (PrintWriter writer = new PrintWriter(new FileWriter(outPutFile));) {
			for (Map.Entry<String, Integer> k : compteurs.entrySet()) {
				System.out.println(k.getKey() + " " + k.getValue());
				writer.println(k.getKey() + " " + k.getValue());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
