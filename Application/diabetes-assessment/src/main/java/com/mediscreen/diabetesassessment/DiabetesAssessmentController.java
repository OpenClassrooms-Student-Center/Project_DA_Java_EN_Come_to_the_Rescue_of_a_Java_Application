package com.mediscreen.diabetesassessment;

import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class DiabetesAssessmentController {
	@RequestMapping("/assess/id")
	public String accessPatient(@RequestParam(value="patId") Long patId) {
		return generateAssessment(getPatientDemographics(patId));
	}

	@RequestMapping("/assess/familyName")
	public String accessPatient(@RequestParam(value="familyName") String familyName) {
		return generateAssessment(getPatientDemographics(familyName));
	}
	
	private Patient getPatientDemographics(Long patId) {
		final String demographicsUri = "http://localhost:8081/patient/getById?Id=" + patId;
		return new RestTemplate().getForObject(demographicsUri, Patient.class);
	}
	
	private Patient getPatientDemographics(String familyName) {
		final String demographicsUri = "http://localhost:8081/patient/getByFamilyName?Name=" + familyName;
	    return new RestTemplate().getForObject(demographicsUri, Patient.class);
	}
	
	private String generateAssessment (Patient patient) {
		return new DiabetesAssessor().access(patient, getPatientHistory(patient.getId()));
	}

	private List<LinkedHashMap<String,String>> getPatientHistory(Long patId) {
		final String historyUri = "http://localhost:8082/patHistory/get?patId=" + patId;
	    return (List<LinkedHashMap<String,String>>) new RestTemplate().getForObject(historyUri, List.class);
	}
}
