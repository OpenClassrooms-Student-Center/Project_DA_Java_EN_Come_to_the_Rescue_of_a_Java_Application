package com.mediscreen.drnotes;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface DrNoteJdbcRepository extends MongoRepository<DrNote, String> {
	public List<DrNote> findByPatientId(Long patientId);
}
