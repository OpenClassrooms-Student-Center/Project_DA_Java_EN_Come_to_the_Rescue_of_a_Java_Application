package com.mediscreen.patientdemographics;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class PatientJdbcRepository {
	@Autowired
	JdbcTemplate jdbcTemplate;

	class PatientRowMapper implements RowMapper<Patient> {
		@Override
		public Patient mapRow(ResultSet rs, int rowNum) throws SQLException {
			Patient Patient = new Patient();
			Patient.setId(rs.getLong("Id"));
			Patient.setGivenName(rs.getString("Given_Name"));
			Patient.setFamilyName(rs.getString("Family_Name"));
			Patient.setBirthDate(rs.getDate("Birth_Date"));
			Patient.setSex(rs.getString("Sex"));
			Patient.setHomeAddress(rs.getString("Home_Address"));
			Patient.setPhoneNumber(rs.getString("Phone_Number"));
			return Patient;
		}

	}

	public List<Patient> findAll() {
		return jdbcTemplate.query("select * from Patient", new PatientRowMapper());
	}

	public Patient findById(long id) {
		return jdbcTemplate.queryForObject("select * from Patient where Id=?", new Object[] { id },
				new BeanPropertyRowMapper<Patient>(Patient.class));
	}

	public Patient findByFamilyName(String familyName) {
		return jdbcTemplate.queryForObject("select * from Patient where Family_Name=?", new Object[] { familyName },
				new BeanPropertyRowMapper<Patient>(Patient.class));
	}
	
	public int deleteById(long id) {
		return jdbcTemplate.update("delete from Patient where Id=?", new Object[] { id });
	}

	public int insert(Patient Patient) {
		return jdbcTemplate.update("insert into Patient (Given_Name, Family_Name, Birth_Date, Sex, Home_Address, Phone_Number) " + "values(?, ?, ?, ?, ?, ?)",
				new Object[] { Patient.getGivenName(), Patient.getFamilyName(),
								Patient.getBirthDate(), Patient.getSex(),
								Patient.getHomeAddress(), Patient.getPhoneNumber() });
	}

	public int update(Patient Patient) {
		return jdbcTemplate.update("update Patient " + " set Given_Name = ?, Family_Name = ?,  Birth_Date = ?, Sex = ?, Home_Address = ?, Phone_Number = ?" + " where Id = ?",
				new Object[] { Patient.getGivenName(), Patient.getFamilyName(),
						Patient.getBirthDate(), Patient.getSex(),
						Patient.getHomeAddress(), Patient.getPhoneNumber(),
						Patient.getId() });
	}
}
