package com.empman.service;

import java.util.List;

import com.empman.entity.Employee;

public interface EmpService {

	Boolean saveEmployee(Employee employee);

	Boolean updateEmployee(Employee employee);

	Employee getEmployeeById(int empId);

	Boolean deleteEmployeeById(int empId);

	List<Employee> getAllEmployee();

}
