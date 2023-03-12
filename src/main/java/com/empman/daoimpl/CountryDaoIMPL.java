package com.empman.daoimpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.empman.dao.CountryDao;
import com.empman.entity.Country;

@Repository
public class CountryDaoIMPL implements CountryDao
{
	@Autowired
	private SessionFactory sessionFactory;
	

	@Override
	public boolean addCountry(Country country) 
	{
		boolean isAdded=false;
		try 
		{
		   Session session = sessionFactory.openSession();
		   Country countrydb=session.get(Country.class, country.getcId());
		   if(countrydb==null)
		   {
			   Transaction transaction = session.beginTransaction();
			   session.saveOrUpdate(country);
			   transaction.commit();
			   isAdded = true;
		   }
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}	
		return isAdded;
	}


	@Override
	public Country getCountryById(int cId) 
	{
		Country country=new Country();
		try 
		{
			Session session = sessionFactory.openSession();
			country = session.get(Country.class, cId);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return country;
	}


	@Override
	public boolean updateCountry(Country country) 
	{
		boolean updated = false;
		try {
			Session session = sessionFactory.openSession();
			Country country2 = session.get(Country.class, country.getcId());
			if(country2!=null) 
			{
				Session session2 = sessionFactory.openSession();
				Transaction transaction = session2.beginTransaction();
				session2.update(country);
				transaction.commit();
				updated=true;
			}
			else
			{
				System.out.println("Country id:"+country.getcId()+" is not exist");
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return updated;
	}


	@Override
	public Country deleteCountryById(int cId) 
	{
		Country country=null;
		try 
		{
			Session session = sessionFactory.openSession();
			country = session.get(Country.class, cId);
			Transaction transaction = session.beginTransaction();
			session.delete(country);
			transaction.commit();
			System.out.println("Country which has "+cId+ " Id is Deleted.");
			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return country;
	}


	@SuppressWarnings({ "deprecation", "unchecked" })
	@Override
	public List<Country> getAllCountries() 
	{	
		List<Country> countries=null;
		try 
		{
			Session session=sessionFactory.openSession();
			Criteria criteria=session.createCriteria(Country.class);
			countries=criteria.list();
			session.close();
			return countries;
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}	
		return countries;
	}
	

}
