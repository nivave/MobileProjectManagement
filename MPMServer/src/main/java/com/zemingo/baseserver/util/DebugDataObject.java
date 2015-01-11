package com.zemingo.baseserver.util;

import java.util.Date;

public class DebugDataObject {
	private Date startOnServer;
	private Date endOnServer;
	
	public void setStartProcessing() {
		startOnServer = new Date();
		
	}
	public void setEndProcessing() {
		endOnServer = new Date();		
	}
	
	public long getServerProccessingTime(){		
		long diff = endOnServer.getTime() - startOnServer.getTime();
		return diff;
	}
}
