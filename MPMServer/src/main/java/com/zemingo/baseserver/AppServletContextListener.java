package com.zemingo.baseserver;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class AppServletContextListener implements ServletContextListener{

//	@Override
	public void contextDestroyed(ServletContextEvent arg0) 
	{
//		GlobalData.killServer();
	} 

//	@Override
	public void contextInitialized(ServletContextEvent arg0) 
	{
//		if (!GlobalData.SERVER_INITIATED){
//			GlobalData.initiateServer();  
//		}	
	}

}
