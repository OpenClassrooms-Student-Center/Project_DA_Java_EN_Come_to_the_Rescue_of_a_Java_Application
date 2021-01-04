package com.hemebiotech.analytics;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Class ExportSymptomsRate: representing a file export in a "result.out file"
 */
public class WriteSymptomRateFromFile implements ISymptomWriter {
	
	/**
	 * 
	 * M�thode g�n�rant un dictionnaire - HashMap cl�(maux) et valeur(occurrence)
	 * 
	 * @param SymptomsRate: 
	 * @author aurelien.ndjamba
	 * @version 1.0
	 * 
	 */
	@Override
	public void writerSymptomsToFile(Map<String, Integer> symptomsRate, String fileToWrite) {

		try {

			FileWriter writer = new FileWriter(fileToWrite);
			
			// Obtenir l'ensemble des cl�s_valeurs sous forme de set
			Set<Map.Entry<String,Integer>> set = symptomsRate.entrySet();
			
			// Obtenir l'iterator pour parcourir le set
	        Iterator<Map.Entry<String,Integer>> it = set.iterator();
			
			while (it.hasNext()) {
				Map.Entry<String,Integer> mentry = it.next();
				writer.write(mentry.getKey() + " : "
						+ mentry.getValue() + "\n");
			}
			
			writer.close();
			
		} 
		catch (FileNotFoundException e) {
			System.out.println("the named file does not exist");

		} 
		catch (IOException e) {
			e.printStackTrace();
		} 
		finally {
//			writer.close(); -> entraine une erreur dans le bloc finally
		}
	}
	
}