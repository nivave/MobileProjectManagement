package com.zemingo.baseserver.model;

import java.util.List;

public class Task {
//members:
	Feature m_feature;

	List<ReportedTime> m_reportedTimeList;
	
	TaskStatusEnum m_taskStatus;

	User m_ownerUser;
	
//methods:
	
	//TODO replace userID type from string to <USERID>?
	public void editEffortEstimation(String requestUserID, CTime newTime){
		
	}
	
	//TODO replace userID type from string to <USERID>?
	public void reportTime(String requestUserID, CTime timeReported){
		
	}
	
}
