package com.hemebiotech.analytics;

public class AnalyticsCounter{
	

		
	public static void main(String args[]) throws Exception {
		SymptomClass headAche = new SymptomClass("headAches", 0);
		SymptomClass rash = new SymptomClass("rashes", 0);
		SymptomClass dialatedPupils = new SymptomClass("dialated pupils", 0);
	
		System.out.println(SymptomClass.getSymptoms(rash));
		System.out.println(SymptomClass.getSymptoms(headAche));
		System.out.println(SymptomClass.getSymptoms(dialatedPupils));
				
		
	}
}
		/**
			private static int headacheCount = 0;	
			private static int rashCount = 0;		
			private static int pupilCount = 0;
	
		 	BufferedReader reader = new BufferedReader (new FileReader("symptoms.txt"));
			String line = reader.readLine();	
		  	while (line != null) {
			if (line.equals("headache")) {
				headacheCount++;
				System.out.println("number of headaches: " + headacheCount);
			}
			else if (line.equals("rash")) {
				rashCount++;
				System.out.println("number of rashes: " + rashCount);
			}
			else if (line.equals("dialated pupils")) {
				pupilCount++;
				System.out.println("number of pupil counts: " + pupilCount);
			}

			line = reader.readLine();	// get another symptom					
			reader.close();		
		}
		**/
		

