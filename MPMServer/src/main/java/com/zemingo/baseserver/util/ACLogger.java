package com.zemingo.baseserver.util;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.FileHandler;
import java.util.logging.Logger;

import com.zemingo.baseserver.GlobalData;
import com.zemingo.baseserver.util.SingleLineFormatter;

public class ACLogger 
{
	private static ACLogger mInstance = null;
	private static Logger mLogger = null;
	
	private ACLogger()
	{
		FileHandler hand = null;
		try {
			
			String logpath = GlobalData.LOG_PATH;
			logpath = logpath.replace("%g", new SimpleDateFormat("dd-MM-yyyy_HH-mm-ss-SSS").format(new Date()));
			
			hand = new FileHandler(logpath,10240000,10,true);
			mLogger = Logger.getLogger("log_file");
			SingleLineFormatter formatterTxt = new SingleLineFormatter();
			hand.setFormatter(formatterTxt);    
		    mLogger.addHandler(hand); 
			
		} catch (SecurityException e) { 
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static Logger getLogger()
	{
		if (mInstance==null){
			mInstance = new ACLogger(); 
		}
		return mLogger;
	}
	
	
	public void info(String msg)
	{
		try{
			mLogger.info(msg);
		}
		catch(Exception ex){}
	}
	
	
	public void warning(String msg)
	{
		try{
			mLogger.warning(msg);
		}
		catch(Exception ex){}
	}
	
	
	public void error(String msg)
	{
		try{
			mLogger.severe(msg);
		}
		catch(Exception ex){}
		
	}
	
	
	public static String stackTraceToString(Throwable e) {
	    try{
			StringBuilder sb = new StringBuilder();
		    for (StackTraceElement element : e.getStackTrace()) {
		        sb.append(element.toString());
		        sb.append("\n");
		    }
		    return sb.toString();
	    }
	    catch(Exception ex){
	    	return null;
	    }
	}
	
	
}
