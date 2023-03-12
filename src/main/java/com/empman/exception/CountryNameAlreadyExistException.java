package com.empman.exception;



public class CountryNameAlreadyExistException extends RuntimeException
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CountryNameAlreadyExistException(String msg) 
	{
		super(msg);
	}

	
}
