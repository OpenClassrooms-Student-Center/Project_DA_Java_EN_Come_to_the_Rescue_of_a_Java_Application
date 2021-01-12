package com.hemebiotech.analytics;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Map;

/**
 * Create a file "result.out" with all symptoms (no duplicate) with their
 * Occurrence
 *
 */
public class WriteSymptomsInFile {
	/**
	 * Map of symptoms (no duplicate) + occurrence
	 */
	public void writeSymptomsInAFile(Map<String, Integer> counterSymptomsABC) {
		try {
			List<String> finalList = counterSymptomsABC.entrySet().stream()
					.map(entry -> entry.getKey() + " : " + entry.getValue()).collect(Collectors.toList());

			Files.write(Paths.get("Project02Eclipse\\src\\results.out"), finalList);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
