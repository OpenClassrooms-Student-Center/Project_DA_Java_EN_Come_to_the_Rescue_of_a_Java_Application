package com.mediscreen.drnotes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DrNoteController {
	@Autowired
	DrNoteJdbcRepository repository;
	
    @RequestMapping("patHistory/add")
    public DrNote drNoteAdd(@RequestParam(value="patId") Long patId,
    						@RequestParam(value="note") String note) {
    	DrNote drNote = new DrNote(patId, note);
    	repository.insert(drNote);
    	dumpAllDrNotesForPatient(patId);
        return drNote;
    }
	
    @RequestMapping("patHistory/update")
    public DrNote drNoteUpdate(@RequestParam(value="patId") Long patId,
								@RequestParam(value="note") String note) {
		return drNoteAdd (patId, note);
    }
	
    @RequestMapping("patHistory/get")
    public List<DrNote> drNoteGet(@RequestParam(value="patId") Long patId) {
		return repository.findByPatientId(patId);
    }

	private void dumpAllDrNotesForPatient(Long patId) {
		System.out.println("Dr Notes for patient: " + patId);
		List<DrNote> allDrNotes = repository.findByPatientId(patId);
		allDrNotes.stream().forEach(drNote -> System.out.println(drNote.toString()));
	}
}
