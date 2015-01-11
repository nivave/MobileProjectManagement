package com.zemingo.baseserver.services.response;

public class ValidationError {
	
	public boolean isError = false;
	public String jsonObjectInString;
	
	public String toString()
	{
		return jsonObjectInString;
	}
	
	public void setError(String error)
	{
		jsonObjectInString = error;
		isError = true;
	}
}
