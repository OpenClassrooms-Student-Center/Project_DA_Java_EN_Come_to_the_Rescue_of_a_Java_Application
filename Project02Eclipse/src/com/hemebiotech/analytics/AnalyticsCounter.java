package com.hemebiotech.analytics;

import java.io.IOException;

/** @
 *
 * @author E.Jurquet
 * 
 * Main Class of the Program AnalyticsCounter.
 * @version 1.1
 *
 */
public class AnalyticsCounter  {
	/**
	Instantiate methods from other classes.
	 */
	public void analyseTheData ()  {

		SymptomsCount symptomscount2 = new SymptomsCount();

		symptomscount2.listAndCountSymptoms();
	}

	/**
	 * Program Start
	 * @param args
	 * @throws IOException
	 *
	 *  This is the main start of the program.
	 *  Instantiate the Analytics class and use the analysis method.
	 */
	public static void main  ( String[] args ){

		AnalyticsCounter analytics = new AnalyticsCounter () ;

		analytics.analyseTheData();
	}
}