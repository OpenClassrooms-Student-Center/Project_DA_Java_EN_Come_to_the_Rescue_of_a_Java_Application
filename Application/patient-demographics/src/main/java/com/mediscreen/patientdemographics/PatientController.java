package com.mediscreen.patientdemographics;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PatientController {
	@Autowired
	PatientJdbcRepository repository;
	
    @RequestMapping("/patient/add")
    public Patient patientAdd(@RequestParam(value="given", defaultValue="Given") String given,
    						@RequestParam(value="family", defaultValue="Family") String family,
    						@RequestParam(value="dob", defaultValue="1941-01-01") Date dob,
    						@RequestParam(value="sex", defaultValue="F") String sex,
							@RequestParam(value="address", defaultValue="000 No Street") String address,
							@RequestParam(value="phone", defaultValue="000-000-0000") String phone) {
    	Patient patient = new Patient(0L, given, family, dob, sex, address, phone);
    	repository.insert(patient);
    	dumpAllPatients();
        return patient;
    }
	
    @RequestMapping("/patient/getById")
    public Patient patientGet(@RequestParam(value="Id") Long Id) {
    	return repository.findById(Id);
    }
	
    @RequestMapping("/patient/getByFamilyName")
    public Patient patientGet(@RequestParam(value="Name") String familyName) {
    	return repository.findByFamilyName(familyName);
    }
	
    @RequestMapping("/patient/remove")
    public Long patientRemove(@RequestParam(value="Id") Long Id) {
    	repository.deleteById(Id);
    	dumpAllPatients();
        return Id;
    }
	
    @RequestMapping("/patient/update")
    public Patient patientUpdate(@RequestParam(value="Id") Long Id,
    		@RequestParam(value="given") String given,
			@RequestParam(value="family") String family,
			@RequestParam(value="dob") Date dob,
			@RequestParam(value="sex") String sex,
			@RequestParam(value="address") String address,
			@RequestParam(value="phone") String phone) {
    	Patient patient = new Patient (Id, given, family, dob, sex, address, phone);
    	repository.update(patient);
    	dumpAllPatients();
        return patient;
    }

	private void dumpAllPatients() {
		System.out.println("List of Patients");
		List<Patient> allPatients = repository.findAll();
		allPatients.stream().forEach(patient -> System.out.println(patient.toString()));
	}
}
