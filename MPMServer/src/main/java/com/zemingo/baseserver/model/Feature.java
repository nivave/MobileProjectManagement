package com.zemingo.baseserver.model;

import java.util.List;

public class Feature {

//members:
	
	private Project m_project;
	
	private String m_version;
	
	private String m_sprint;
	
	private FeatureStatusEnum m_featureStatus;
	
	private List<Task> m_tasksList;
	
	private PlatformEnum m_platform;

//methods:
	
	//TODO replace userID type from string to <USERID>?
	public void addTask(String requestUserID, String Name, String description){
		
	}
	
	//TODO replace userID type from string to <USERID>?
	public void assignTaskToUser(String requestUserID, Task task, String assignToUserID){
		
	}
	
	//TODO replace userID type from string to <USERID>?
	public void editEffortEstimation(String requestUserID, CTime newTime){
		
	}
	
	
}
