package com.empman.serviceimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empman.dao.EmpDao;
import com.empman.entity.Employee;
import com.empman.service.EmpService;
@Service
@Transactional
public class EmpServiceImpl implements EmpService
{

	@Autowired
	EmpDao empDao;
	
	@Override
	public Boolean saveEmployee(Employee employee) {
		return empDao.saveEmployee(employee);
	}

	@Override
	public Boolean updateEmployee(Employee employee) 
	{
		
		return empDao.updateEmployee(employee);
	}

	@Override
	public Employee getEmployeeById(int empId) 
	{
		
		return empDao.getEmployeeById(empId);
	}

	@Override
	public Boolean deleteEmployeeById(int empId) 
	{
		return empDao.deleteEmployeeById(empId);
	}

	@Override
	public List<Employee> getAllEmployee() 
	{
		
		return empDao.getAllEmployee();
	}
}
