package com.hemebiotech.analytics;

import java.util.Map;

public class AnalyticsCounter {
	public static void main(String[] args) throws Exception {

		Map<String, Integer> symptoms = new Fillmap().fill();
		FillResult fillResult = new FillResult();
		fillResult.write(symptoms);
	}
}