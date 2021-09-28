package com.example.exception;

public class MonthNotFoundException extends RuntimeException {

	public MonthNotFoundException(String message)
	{
		super(message);
	}
}
