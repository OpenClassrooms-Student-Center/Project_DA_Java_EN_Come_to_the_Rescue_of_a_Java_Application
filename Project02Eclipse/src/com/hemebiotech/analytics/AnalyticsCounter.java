package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class AnalyticsCounter {
	/**
	 * The entry point of the program
	 * @param args
	 */
	public static void main(String args[]) {
		try {
			AnalyticsCounterProgram program = new AnalyticsCounterProgram();
			program.start();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
