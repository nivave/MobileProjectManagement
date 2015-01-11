package com.zemingo.baseserver.services;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.JsonNode;


public class JSonValidator 
{
	private String[] mMissingKeys;
	private List<String> mMissingKeysList;
	
	public boolean validateJsonKeysExist(JsonNode jn, String[] keys)
	{
		boolean res = true;
		mMissingKeysList = new ArrayList<String>();
		for (int i=0; i< keys.length; i++)
		{
			if (!jn.has(keys[i])){
				res = false;
				mMissingKeysList.add(keys[i]);
			}
		}
		if (!res){
			mMissingKeys = new String[mMissingKeysList.size()];
			mMissingKeys = mMissingKeysList.toArray(mMissingKeys)	;
		
		}
		return res;
	}
	
	public String[] getMeissingKeys()
	{
		return mMissingKeys;
	}
	
	public String getMeissingKeysAsString()
	{
		String res = "";
		try{
			for(int i=0;i<mMissingKeys.length;i++)
			{
				res = res +  mMissingKeys[i] + ",";
			}
			if (res.endsWith(",")){
				res = res.substring(0, res.length()-1);
			}
			return res;
		}
		catch (Exception ex){
			return "";
		}
	}
}
