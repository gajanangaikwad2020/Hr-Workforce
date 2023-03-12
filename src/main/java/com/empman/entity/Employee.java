package com.empman.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="Employee")
public class Employee 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="Id")
	private int empId;
	
	@Column(name="Name")
//	@NotNull(message = "Employee name is Required")
	private String empName;	
	
	@Column(name="Address")
//	@NotNull(message = "Employee Address is Required")
	private String empAddress;
	
	@Column(name="Salary")
//	@Min(1)
	private double salary;
	
	@Column(name="Department")
//	@NotNull(message = "Employee Department is Required")
	private String empDept;
	
	@OneToOne(cascade = CascadeType.PERSIST)
	private Country country;
	
	@OneToMany
	private List<Contact> contact;
	
//	@OneToMany(cascade = CascadeType.ALL)
//	private List<Office> office;
	
	


}
