package com.mediscreen.drnotes;

import org.springframework.data.annotation.Id;

public class DrNote {
    @Id
    public String id;
    public Long patientId;
    public String note;

    public DrNote() {}

    public DrNote(Long _patientId, String _note) {
    	patientId = _patientId;
    	note = _note;
    }
	
	public String getId() {
		return id;
	}
	public void setId(String _id) {
		id = _id;
	}
	
	public Long getPatientId() {
		return patientId;
	}
	public void setGivenName(Long _patientId) {
		patientId = _patientId;
	}
	
	public String getNote() {
		return note;
	}
	public void setNote(String _note) {
		note = _note;
	}

    @Override
    public String toString() {
        return String.format(
                "Note [id=%s, patientId='%s', note='%s']",
                id, patientId, note);
    }
}
