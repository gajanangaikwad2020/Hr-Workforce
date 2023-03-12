package com.empman.daoimpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.empman.dao.EmpDao;
import com.empman.entity.Employee;
@Repository
public class EmpDaoImpl implements EmpDao
{
	@Autowired
	SessionFactory factory;
	
	@Override
	public Boolean saveEmployee(Employee employee) 
	{
		boolean isSaved=false;
		try 
		{
			Session session = factory.openSession();
			Transaction transaction = session.beginTransaction();
			session.save(employee);
			transaction.commit();
			System.out.println("In Dao "+ employee);
			isSaved=true;
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		return isSaved;			
	}

	@Override
	public Boolean updateEmployee(Employee employee) 
	{
		Session session = factory.openSession();
		boolean isUpdated=false;
		try 
		{
			Employee dbEmployee = session.get(Employee.class, employee.getEmpId());
			if (dbEmployee!=null) 
			{
				Transaction transaction = session.beginTransaction();
				session.evict(dbEmployee);
				session.update(employee);
				transaction.commit();
				isUpdated=true;
			}
			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		return isUpdated;	
	}

	@Override
	public Employee getEmployeeById(int empId) 
	{
		Session session = factory.openSession();
		Employee dbEmployee = session.get(Employee.class, empId);
		return dbEmployee;
	}

	@Override
	public Boolean deleteEmployeeById(int empId) 
	{
		Boolean isDeleted=false;
		try 
		{
			Session session = factory.openSession();
			Employee dbEmployee = session.get(Employee.class, empId);
			if (dbEmployee!=null) 
			{
				Transaction transaction = session.beginTransaction();
				session.delete(dbEmployee);
				transaction.commit();
				isDeleted=true;
			} 
			else 
			{
				isDeleted=false;
			}
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}		
		return isDeleted;
	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	@Override
	public List<Employee> getAllEmployee() 
	{
		List<Employee> employeesList=null;
		try 
		{
			Session session = factory.openSession();
			Criteria criteria = session.createCriteria(Employee.class);
			employeesList=criteria.list();
			return employeesList;
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return employeesList;
	}
	

}
