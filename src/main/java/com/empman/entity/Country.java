package com.empman.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

//@Data
@Entity
public class Country 
{
	@Id
//	@GeneratedValue (strategy = GenerationType.AUTO) //Bydefault by 1
	private int cId;
	private String cName;
	public int getcId() {
		return cId;
	}
	public void setcId(int cId) {
		this.cId = cId;
	}
	public String getcName() {
		return cName;
	}
	public void setcName(String cName) {
		this.cName = cName;
	}
	public Country(int cId, String cName) {
		super();
		this.cId = cId;
		this.cName = cName;
	}
	public Country() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Country [cId=" + cId + ", cName=" + cName + "]";
	}
	
	
	
}
