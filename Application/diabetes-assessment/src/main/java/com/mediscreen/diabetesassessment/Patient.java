package com.mediscreen.diabetesassessment;

import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;

public class Patient {
	private Long id;
	private String givenName;
	private String familyName;
	private Date birthDate;
	private String sex;
	private String homeAddress;
	private String phoneNumber;
	
	public Patient() {
		super();
	}
	
	public Patient(Long _id, String _givenName, String _familyName,
					Date _birthDate, String _sex,
					String _homeAddress, String _phoneNumber) {
		id = _id;
		givenName = _givenName;
		familyName = _familyName;
		birthDate = _birthDate;
		sex = _sex;
		homeAddress = _homeAddress;
		phoneNumber = _phoneNumber;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long _id) {
		id = _id;
	}
	
	public String getGivenName() {
		return givenName;
	}
	public void setGivenName(String _givenName) {
		givenName = _givenName;
	}
	
	public String getFamilyName() {
		return familyName;
	}
	public void setFamilyName(String _familyName) {
		familyName = _familyName;
	}
	
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date _birthDate) {
		birthDate = _birthDate;
	}
	
	public String getSex() {
		return sex;
	}
	public void setSex(String _sex) {
		sex = _sex;
	}
	
	public String getHomeAddress() {
		return homeAddress;
	}
	public void setHomeAddress(String _homeAddress) {
		homeAddress = _homeAddress;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String _phoneNumber) {
		phoneNumber = _phoneNumber;
	}
	
	public int getAge() {
		LocalDate bdate = birthDate.toLocalDate();
		LocalDate currentDate = LocalDate.now();
		return Period.between(bdate, currentDate).getYears();
	}
	
	@Override
	public String toString() {
		return String.format("Patient [id=%s, family=%s, given=%s, sex=%s, birth=%s, address=%s, phone=%s]",
								id, familyName, givenName, sex, birthDate, homeAddress, phoneNumber);
	}
}
