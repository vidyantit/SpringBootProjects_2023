package com.vid.springboot.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Table(name="country_table")
@Entity
public class Country {

	@Id
	int countryId;
	String countryName;
	String countryCapital;
	public int getCountryId() {
		return countryId;
	}
	public void setCountryId(int countryId) {
		this.countryId = countryId;
	}
	public String getCountryName() {
		return countryName;
	}
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	public String getCountryCapital() {
		return countryCapital;
	}
	public void setCountryCapital(String countryCapital) {
		this.countryCapital = countryCapital;
	}
	public Country(int countryId, String countryName, String countryCapital) {
		super();
		this.countryId = countryId;
		this.countryName = countryName;
		this.countryCapital = countryCapital;
	}
	public Country() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
