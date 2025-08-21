package com.hemebiotech.analytics.services;

import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;

import com.hemebiotech.analytics.interfaces.ISymptomInsightWriter;

public class WriteInsightToFile implements ISymptomInsightWriter {

		public void writeInsightGenerator (String insights, String outinsightFile) {
			try (BufferedWriter writer = new BufferedWriter (new FileWriter(outinsightFile))) {
			    writer.write(insights);
	            writer.newLine();
	        } catch (IOException e) {
	            System.err.println("Erreur lors de l'écriture du résumé IA : " + e.getMessage());
	        }
	    }
	}