package com.zemingo.baseserver.services;

import com.zemingo.baseserver.util.DebugDataObject;

public class ServiceResponse
{		
	public class Result
	{
		
	}
		
	public ACError ErrorObj;
	public Object Result;
	public DebugDataObject DebugData;
	
	public ServiceResponse()	{
		DebugData = new DebugDataObject();	
		DebugData.setStartProcessing();
	}
	
	public void setResponse(ACError errobj, Object resObj)
	{		
		ErrorObj = errobj;
		Result = resObj;
		DebugData.setEndProcessing();
	}
}