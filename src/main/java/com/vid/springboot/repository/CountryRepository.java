package com.vid.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vid.springboot.entity.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country,Integer> {

	
	//Country getCountryByName(String countryName);

}
