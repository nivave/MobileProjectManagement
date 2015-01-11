package com.zemingo.baseserver;

import java.util.Dictionary;
import java.util.Hashtable;



public class ACErrorList
{
	private static ACErrorList mInstance;
	private Dictionary<ACErrorEnum,String> mErrHash;

	private ACErrorList()
	{
		mErrHash = new Hashtable<ACErrorEnum, String>();
		mErrHash.put(ACErrorEnum.ERROR_JSON_KEY_IS_MISSING, "ERROR_JSON_KEY_IS_MISSING");
		mErrHash.put(ACErrorEnum.ERROR_JSON_OBJECT_IS_NOT_VALID, "Json Object is not valid");
		mErrHash.put(ACErrorEnum.ERROR_INVALID_USER_TOKEN, "ERROR_INVALID_USER_TOKEN");
		mErrHash.put(ACErrorEnum.ERROR_INVALID_REGISTRATION_CODE, "Invalid registration code");
		mErrHash.put(ACErrorEnum.ERROR_FULL_SYSNC_REQUIRED, "Full sync required");
		mErrHash.put(ACErrorEnum.ERROR_CONTACT_ID_ALREADY_EXIST, "ERROR_CONTACT_ID_ALREADY_EXIST");		
		mErrHash.put(ACErrorEnum.ERROR_UNKOWN_ERROR, "Unknown Error");
	}

	public static ACErrorList getErrors()
	{
		if (mInstance == null){
			mInstance = new ACErrorList();
		}
		return mInstance;
	}

	public String getMessage(ACErrorEnum err)
	{
		try{
			return mErrHash.get(err);
		}
		catch(Exception ex){
			return "Unknown Error";
		}
	}

}
