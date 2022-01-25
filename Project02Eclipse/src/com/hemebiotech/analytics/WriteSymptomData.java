package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class WriteSymptomData implements ISymptomWriter {

	public void WriteSymptoms(ArrayList<String> listeSymptomes) {

		try {
			FileWriter writer = new FileWriter("result.out");
			for (int i = 0; i < listeSymptomes.size(); i++) {
				writer.write(listeSymptomes.get(i) + "\n");
			}
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
