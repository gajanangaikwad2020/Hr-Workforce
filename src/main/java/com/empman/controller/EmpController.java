package com.empman.controller;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.empman.entity.Employee;
import com.empman.exception.InvalidCredentialsException;
import com.empman.exception.ResourceNotFoundException;
import com.empman.service.EmpService;

@RestController
@RequestMapping(value = "/employee")
public class EmpController 
{
	@Autowired
	EmpService empService;
	
	
//	@RequestMapping("/")
//	public String home()
//	{
//		System.out.println("This is Home Page..");
//		return "home";
//	}
//	
	@PostMapping(value="/save-emp")
	public ResponseEntity<String> saveEmployee(@RequestBody Employee employee) 
	{
		System.out.println(employee);
		Boolean isSaved= empService.saveEmployee(employee);
		if(isSaved)
		{
			return new ResponseEntity<String>("Employee is Saved.",HttpStatus.CREATED);
		}
		else
		{
			throw new InvalidCredentialsException("Method Argument are Not Valid for id -> "+employee.getEmpId());
		}
	}
	
	@PutMapping(value="/update-emp")
	public ResponseEntity<String> updateEmployee(@RequestBody Employee employee) 
	{
		
		Boolean isUpdated= empService.updateEmployee(employee);
		if(isUpdated)
		{
			return new ResponseEntity<String>("Employee is Updated.",HttpStatus.CREATED);
		}
		else
		{
			throw new ResourceNotFoundException("Resource Not Found for id ->"+employee.getEmpId());
		}
	}
	
	@GetMapping(value="/get-emp-by-id/{empId}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable int empId) 
	{
		
		Employee dbEmployee= empService.getEmployeeById(empId);
		if(dbEmployee!=null)
		{
			return new ResponseEntity<Employee>(dbEmployee,HttpStatus.CREATED);
		}
		else
		{
			throw new ResourceNotFoundException("Employee Not Found for id ->"+empId);
		}
	}

	@DeleteMapping(value="/delete-emp-by-id/{empId}")
	public ResponseEntity<String> deleteEmployee(@PathVariable int empId) 
	{
		
		Boolean isDeleted= empService.deleteEmployeeById(empId);
		if(isDeleted)
		{
			return new ResponseEntity<String>("Employee is Deleted with id ->"+empId,HttpStatus.CREATED);
		}
		else
		{
			throw new ResourceNotFoundException("Resource is Not Found for id ->"+empId);
		}
	}
	@GetMapping(value="/get-all-employee")
	public ResponseEntity<List<Employee>> getAllEmployee() 
	{
		
		List<Employee> dbEmployee= empService.getAllEmployee();
		if(dbEmployee!=null)
		{
			return new ResponseEntity<List<Employee>>(dbEmployee,HttpStatus.CREATED);
		}
		else
		{
			throw new ResourceNotFoundException("Resource Not Found.");
		}
	}
}
