package com.mediscreen.patientdemographics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PatientDemographicsApplication implements CommandLineRunner {
	@Autowired
	PatientJdbcRepository repository;
	
	public static void main(String[] args) {
		SpringApplication.run(PatientDemographicsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Patient id 1 -> " + repository.findById(1L));
	}
}
