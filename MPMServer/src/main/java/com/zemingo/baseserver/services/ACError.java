package com.zemingo.baseserver.services;

import com.zemingo.baseserver.ACErrorEnum;
import com.zemingo.baseserver.ACErrorList;

public class ACError
{
	public String errorDesc;
	public String errorMessage;
	public int errorCode;	
	
	public ACError()
	{
		
	}
	
	public ACError(int code, String msg, String desc){
		errorCode = code;
		errorMessage = msg;
		errorDesc = desc;
	}	
	
	public static ACError factory(ACErrorEnum err){
		return factory(err, ACErrorList.getErrors().getMessage(err));		
	}
	
	public static ACError factory(ACErrorEnum err, String description){		
		ACError tempErr = new ACError(err.getValue(), ACErrorList.getErrors().getMessage(err), description);
		return tempErr;
		
	}
}