package com.mediscreen.diabetesassessment;

import java.util.LinkedHashMap;
import java.util.List;

/*
 * A patient will have one of 4 risk levels.
None
Borderline
In danger
Early Onset.
The rules for determining the risk levels are as follows.
None - patient has no doctor’s notes containing any of the trigger terminology.
Borderline - patient has a reference to two triggers, and is over 30 years of age.
In danger - depends on patient’s age and sex. If under 30, and male, then three trigger terms.
If under 30 and female, four trigger terms. If either over 30, then six.
Early Onset - again, depends on age and sex.  If under 30, and male, then five trigger terms.
If under 30 and female, seven trigger terms. If over 30, then eight or more.”
 */
public class DiabetesAssessor {
	private final String [] Assessments = { "None", "Borderline", "In danger", "Early onset" };
	enum Assessment {
		ASSESSMENT_NONE(0),
		ASSESSMENT_BORDERLINE(1),
		ASSESSMENT_IN_DANGER(2),
		ASSESSMENT_EARLY_ONSET(3);
		
		private int value;
		
		private Assessment(int _value) {
			value = _value;
		}
		
		public int getValue() {
			return value;
		}
	}
	
	private final String [] keywords = { "Hemoglobin A1C", "Microalbumin",
											"Body Height", "Body Weight",
											"Smoker", "Abnormal", "Cholesterol",
											"Dizziness", "Relapse", "Reaction", "Antibodies" };
	

	
	private final int NUM_BORDERLINE_TRIGGERS = 2;
	private final int NUM_IN_DANGER_TRIGGERS_MALE_UNDER_30 = 3;
	private final int NUM_IN_DANGER_TRIGGERS_FEMALE_UNDER_30 = 4;
	private final int NUM_IN_DANGER_TRIGGERS_OVER_30 = 6;
	private final int NUM_EARLY_ONSET_TRIGGERS_MALE = 5;
	private final int NUM_EARLY_ONSET_TRIGGERS_FEMALE_UNDER_30 = 7;
	
	public String access(Patient patient, List<LinkedHashMap<String,String>> notes) {
		String assessment = evaluateAssessment(patient, notes);
		return generateTextResult(patient, assessment);
	}

	private String evaluateAssessment(Patient patient, List<LinkedHashMap<String,String>> notes) {
		int age = patient.getAge();
		int numTriggerTerms = getNumberOfTriggerTerms(notes);
		Assessment assessment = getAssessmentValue (age, numTriggerTerms, patient.getSex());
		System.out.println("Patient is " + age + " years old, with " + numTriggerTerms + " trigger words, and assessment of: " + assessment);
		return Assessments [assessment.getValue()];
	}

	private int getNumberOfTriggerTerms(List<LinkedHashMap<String,String>> notes) {
		int numTriggerTerms = 0;
		for (LinkedHashMap<String,String> note : notes) {
			String drNote = note.get("note");
			for (String keyword : keywords) {
				if (drNote.contains(keyword)) {
					++numTriggerTerms;
				}
			}
		}
		return numTriggerTerms;
	}

	private Assessment getAssessmentValue(int age, int numTriggerTerms, String sex) {
		if (isEarlyOnset (age, numTriggerTerms, sex)) {
			return Assessment.ASSESSMENT_EARLY_ONSET;
		}
		
		if (isInDanger (age, numTriggerTerms, sex)) {
			return Assessment.ASSESSMENT_IN_DANGER;
		}
		
		if (isBoderline (age, numTriggerTerms)) {
			return Assessment.ASSESSMENT_BORDERLINE;
		}

		return Assessment.ASSESSMENT_NONE;
	}

	private boolean isBoderline(int age, int numTriggerTerms) {
		return (age > 30) && (numTriggerTerms >= NUM_BORDERLINE_TRIGGERS);
	}

	private boolean isInDanger(int age, int numTriggerTerms, String sex) {
		if (sex.equals("M")) {
			if (age < 30) {
				if (numTriggerTerms >= NUM_IN_DANGER_TRIGGERS_MALE_UNDER_30)
					return true;
			}
		} else {
			if (age < 30) {
				if (numTriggerTerms >= NUM_IN_DANGER_TRIGGERS_FEMALE_UNDER_30)
					return true;
			}
		}
			
		return numTriggerTerms > NUM_IN_DANGER_TRIGGERS_OVER_30;
	}

	private boolean isEarlyOnset(int age, int numTriggerTerms, String sex) {
		if (sex.equals("M")) {
			if (numTriggerTerms >= NUM_EARLY_ONSET_TRIGGERS_MALE)
				return true;
			return false;
		}
		else {
			if (age < 30) {
				if (numTriggerTerms >= NUM_EARLY_ONSET_TRIGGERS_FEMALE_UNDER_30) {
					return true;
				}
			}
			else if (numTriggerTerms >= NUM_EARLY_ONSET_TRIGGERS_FEMALE_UNDER_30) {
				return true;
			}
		}
		
		return false;
	}

	private String generateTextResult(Patient patient, String assessment) {
		return "Patient: "
				+ patient.getGivenName() + " "
				+ patient.getFamilyName()
				+ " (age " + patient.getAge() + ")"
				+ " diabetes assessment is: "
				+ assessment;
	}
}
