package com.vid.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.vid.springboot.entity.Country;
import com.vid.springboot.service.CountryService;

@RestController
public class CountryController {

	@Autowired
	CountryService countryService;
	
	@GetMapping("/getAllCountries")
	public List<Country> getCountries() 
	{
		return countryService.getAllCountries();
	} 	

	
	
	@GetMapping("/getCountry/{id}")
	public ResponseEntity<Country> getCountryById(@PathVariable(value="id") int countryId)
	{
		try {
			Country country =countryService.getCountryById(countryId);
			return new ResponseEntity<Country>(country,HttpStatus.OK);
			
		}catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		  	
	}
	
	/*
	 * @GetMapping("/getCountryByName/{Countryname}") public ResponseEntity<Country>
	 * getCountryByName(@PathVariable(value="Countryname") String Countryname) { try
	 * { Country country =countryService.getCountryByName(Countryname); return new
	 * ResponseEntity<Country>(country,HttpStatus.OK);
	 * 
	 * }catch(Exception e) { return new ResponseEntity<>(HttpStatus.NOT_FOUND); } }
	 */
	
	@PostMapping("/addCountry")
	public Country addCountry(@RequestBody Country country) {
		return countryService.addCountry(country);
	}
	
	@PutMapping("/updateCountry/{id}")
	public ResponseEntity<Country> updateCountry(@PathVariable(value="id") int id, @RequestBody Country updateCountry) {
		try {
			Country existCountry=countryService.getCountryById(id);
			existCountry.setCountryName(updateCountry.getCountryName());
			existCountry.setCountryCapital(updateCountry.getCountryCapital());
			Country updated_country=countryService.updateCountry(existCountry);
			return new ResponseEntity<Country>(updated_country,HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<Country>(HttpStatus.CONFLICT);
		}
	}
	
	@DeleteMapping("/deleteCountry/{id}")
	public AddResponse deleteCountry(@PathVariable(value="id") int id) {
		return countryService.deleteCountry(id);
	}

	
}
