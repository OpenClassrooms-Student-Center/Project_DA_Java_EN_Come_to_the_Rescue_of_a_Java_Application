package com.hemebiotech.analytics;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map.Entry;
import java.util.TreeMap;

/**
 * 
 * @param outputFile a full or partial path to file with symptom strings in it,
 *                   one per line
 * 
 *                   Voir si besoin d'une nouvelle méthode pour mettre dans
 *                   l'ordre ? TO DO : automatiser l'écriture du fichier.
 */
public class WriteSymptomOnFile implements ISymptomWriter {

	private String outputFile;
	

	public WriteSymptomOnFile(String outputFile) throws IOException {
		this.outputFile = outputFile;
	}
	
	@Override
	public void writeSymptoms (TreeMap<String, Integer> nbOccurrence) throws IOException{
			
		 try (FileWriter fileWriter = new FileWriter(outputFile, false);
				BufferedWriter writer = new BufferedWriter (fileWriter)) {
			 for (Entry<String, Integer> entry : nbOccurrence.entrySet()) {
					writer.write(entry.getKey()+" = "+entry.getValue());
					writer.newLine();
				}
				writer.close();

			}catch (IOException e) {
				e.printStackTrace();
			}
		}
}


