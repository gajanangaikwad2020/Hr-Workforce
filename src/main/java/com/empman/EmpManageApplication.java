package com.empman;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@EnableAutoConfiguration(excludeName = "com.empman.serviceimpl.EmpServiceImpl")
//@ComponentScan(excludeFilters = )
public class EmpManageApplication 
{
	public static void main(String[] args) 
	{
		SpringApplication.run(EmpManageApplication.class, args);
		System.out.println("Started..");
		
		
//		String str="45";
//		System.out.println("Address :"+ VM.current().addressOf(str));
//		System.out.println("hashcode :"+str.hashCode());
//		
	}
}
