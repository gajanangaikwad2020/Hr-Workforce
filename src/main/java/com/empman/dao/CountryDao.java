package com.empman.dao;

import java.util.List;

import com.empman.entity.Country;

public interface CountryDao 
{

	public boolean addCountry(Country country);

	public Country getCountryById(int empId);

	public boolean updateCountry(Country country);

	public Country deleteCountryById(int empId);

	public List<Country> getAllCountries();
	

}
