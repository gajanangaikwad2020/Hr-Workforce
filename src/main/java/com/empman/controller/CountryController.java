package com.empman.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.empman.dao.CountryDao;
import com.empman.entity.Country;
import com.empman.exception.CountryNameAlreadyExistException;
import com.empman.exception.CountryNotFoundException;
import com.empman.service.CountryService;

@RestController
@RequestMapping(value = "/country")
@CrossOrigin
public class CountryController 
{
	@Autowired
	private CountryService countryService;

	@Autowired
	private CountryDao countryDao;

	@PostMapping(value = "/add-country")
	public ResponseEntity<Object> addCountry(@Valid @RequestBody Country country) 
	{
		boolean isAdded = countryService.addCountry(country);
		if(isAdded)
		{
			return new ResponseEntity<Object>("New Country Record is Added With C-Id :"+country.getcId(),HttpStatus.CREATED);
		}
		else
		{
			throw new CountryNameAlreadyExistException("Country Name is Already Exist for Emp-Id :"+country.getcId());
		}
	}
	
	@PutMapping(value = "/update-country")
	public ResponseEntity<Object> updateCountry(@Valid @RequestBody Country country) 
	{
		
		Country cId =countryDao.getCountryById(country.getcId());
		if(cId!=null)
		{
			if(countryService.updateCountry(country))
			{	
				return new ResponseEntity<Object>("Country is Updated of Emp-Id :"+country.getcId(), HttpStatus.CREATED);
			}
			else
			{
				throw new CountryNameAlreadyExistException("Country Name Already Exist for Id :");
			}
		}
		else
		{
			throw new CountryNotFoundException("Country Id ->"+country.getcId()+" Not Exist for Update the Country.");
		}
		
	}
	
	@SuppressWarnings({ "unused" })
	@GetMapping(value = "/get-country-by-id/{cId}")
	public ResponseEntity<Country> getCountryById(@Valid @PathVariable int cId) 
	{
//		Country country = null;
		Country country2 = countryService.getCountryById(cId);
		if(country2!=null)
		{
			return new ResponseEntity<Country>(country2, HttpStatus.OK);
		}
		else
		{
			throw new CountryNotFoundException("Country Not Found with EmpId :"+cId);
		}
	}
	
	@DeleteMapping(value = "/delete-country-by-id/{cId}")
	public ResponseEntity<String> deleteCountryById(@Valid @PathVariable int cId) 
	{
		Country country = null;
		country = countryService.deleteCountryById(cId);
		
		if(country!=null)
		{
			return new ResponseEntity<String>("Country is Deleted Which has Id :"+cId, HttpStatus.OK);
		}
		else
		{
			throw new CountryNotFoundException("Country is Not Found for Id :"+cId);
		}
	}
	
	@GetMapping(value = "/get-all-countries")
	public ResponseEntity<List<Country>> getAllCountries() 
	{
		  List<Country> allCountrys = countryService.getAllCountries();
		  return new ResponseEntity<List<Country>>(allCountrys, HttpStatus.OK);
	}
}