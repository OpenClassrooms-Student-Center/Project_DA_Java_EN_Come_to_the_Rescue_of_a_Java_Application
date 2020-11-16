package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class AnalyticsCounter {
	/**
	 *
	 * @param args
	 * @throws IOException
	 */
	public static void main(String args[]) throws IOException {
		AnalyticsCounterProgram program = new AnalyticsCounterProgram();
		program.start();
	}
}
