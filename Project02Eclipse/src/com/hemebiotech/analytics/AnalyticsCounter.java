package com.hemebiotech.analytics;

/**
 * Application entry class
 *
 * @author trimok
 *
 */
public class AnalyticsCounter {
	/**
	 * Application entry point
	 * 
	 * @param args : No argument in the command line
	 * @throws Exception : the global exception
	 */
	public static void main(String args[]) throws Exception {
		IAnalyticsService service = new AnalyticsService();
		service.doSymptomCountAnalysis();
	}
}
