package com.empman.dao;

import java.util.List;

import com.empman.entity.Employee;

public interface EmpDao 
{

	Boolean saveEmployee(Employee employee);

	Boolean updateEmployee(Employee employee);

	Employee getEmployeeById(int empId);

	Boolean deleteEmployeeById(int empId);

	List<Employee> getAllEmployee();

}
