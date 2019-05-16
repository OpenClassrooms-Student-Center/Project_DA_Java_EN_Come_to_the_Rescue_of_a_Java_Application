package com.mediscreen.drnotes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DrNotesApplication implements CommandLineRunner  {
	@Autowired
	private DrNoteJdbcRepository repository;
	
	public static void main(String[] args) {
		SpringApplication.run(DrNotesApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		/*
		repository.deleteAll();

		// save a couple of customers
		repository.insert(new DrNote(1L, "Chronic whiner"));
		repository.insert(new DrNote(2L, "Too dumb"));
		repository.insert(new DrNote(1L, "Non compliant"));
		*/
		
		// fetch all customers
		System.out.println("Doctor's notes found with findAll():");
		System.out.println("-------------------------------");
		for (DrNote drNote : repository.findAll()) {
			System.out.println(drNote);
		}
		System.out.println();

		// fetch an individual customer
		System.out.println("Doctor's note found with findByPatientId(1):");
		System.out.println("--------------------------------");
		System.out.println(repository.findByPatientId(1L));
	}
}
