package com.empman.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empman.dao.CountryDao;
import com.empman.entity.Country;
import com.empman.service.CountryService;
@Service
public class CountryServiceIMPL implements CountryService
{
	@Autowired
	private CountryDao countryDao;
	
	@Override
	public boolean addCountry(Country country) {
		
		return countryDao.addCountry(country) ;
	}

	@Override
	public Country getCountryById(int cId) {
	
		return countryDao.getCountryById(cId);
	}

	@Override
	public boolean updateCountry(Country country) 
	{
		
		return countryDao.updateCountry(country);
	}

	@Override
	public Country deleteCountryById(int cId) 
	{
		return countryDao.deleteCountryById(cId);
	}

	
	@Override
	public List<Country> getAllCountries() 
	{
		
		return countryDao.getAllCountries();
	}	

}
