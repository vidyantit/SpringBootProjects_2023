package com.vid.springboot.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.vid.springboot.controller.AddResponse;
import com.vid.springboot.entity.Country;
import com.vid.springboot.repository.CountryRepository;

@Component
@Service
public class CountryService
{

@Autowired
CountryRepository countryRepository;
	
	
		 public List<Country> getAllCountries() {
			 return countryRepository.findAll();
		 }
		 
		 public Country getCountryById(int id) {
			return countryRepository.findById(id).get();
		 }
		 
			/*
			 * public Country getCountryByName(String countryName) { List<Country>
			 * countries=countryRepository.findAll(); Country country=null; for(Country
			 * con:countries) { if(con.getCountryName().equalsIgnoreCase(countryName))
			 * country=con; } return country; }
			 */
		 public Country addCountry(Country country) {
			country.setCountryId(getMaxId());
		    countryRepository.save(country);
		    return country;
		 }
		 
		 //updating country
		 public Country updateCountry(Country country) 
		 {
			 countryRepository.save(country);
			 return country;
			 }
		 
	//delete country
	
	  public AddResponse deleteCountry(int id) {
	  countryRepository.deleteById(id);
	  AddResponse res=new AddResponse();
	  res.setMsg("Country Deleted...");
	  res.setId(id);
	  return res;
	  }
	 
	public  int getMaxId() {
		return countryRepository.findAll().size()+1;
	}
	
}

