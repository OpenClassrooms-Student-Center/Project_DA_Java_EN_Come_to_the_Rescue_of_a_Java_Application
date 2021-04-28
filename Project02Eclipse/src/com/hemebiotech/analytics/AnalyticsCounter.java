package com.hemebiotech.analytics;


public class AnalyticsCounter {
	
//	private static int headacheCount = 0;	// initialize to 0
//	private static int rashCount = 0;		// initialize to 0
//	private static int pupilCount = 0;		// initialize to 0
		
	public static void main(String args[]) throws Exception {
		SymptomClass test = new SymptomClass("headache", 1);
		SymptomClass.setSymptoms(test,"test", 0);
		test.getSymptoms();
//		BufferedReader reader = new BufferedReader (new FileReader("symptoms.txt"));
//		String line = reader.readLine();
//		LinkedList <String> logSymptomes = new LinkedList<String>();
//		boolean iterator = true;
//				
//		while (iterator) {
//			line = reader.readLine();
//			logSymptomes.add(line);
//			Collections.sort(logSymptomes);
//			System.out.println(logSymptomes);
//			if (line.equals("")) {
//				iterator = false;
//			}
//		}
//		
		
		
		/**while (line != null) {
			System.out.println("symptom from file: " + line);
			if (line.equals("headache")) {
				headacheCount++;
				System.out.println("number of headaches: " + headacheCount);
			}
			else if (line.equals("rash")) {
				rashCount++;
			}
			else if (line.equals("pupils")) {
				pupilCount++;
			}**/

			
		
//		reader.close();
//		
//		// next generate output
//		FileWriter writer = new FileWriter ("result.out");
//		writer.write("headache: " + headacheCount + "\n");
//		writer.write("rash: " + rashCount + "\n");
//		writer.write("dialated pupils: " + pupilCount + "\n");
//		writer.close();
	}
}
