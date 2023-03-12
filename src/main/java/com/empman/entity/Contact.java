package com.empman.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Contact 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int  id;
	private int mobileNo;
	private String landline;
	

}
