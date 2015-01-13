package com.zemingo.baseserver.model;

import java.util.List;

public class Project {

//members:
	
	//costumer's details
	//TODO - decide if should be string or object (CostumerDetails)
	private CostumerDetails m_costumerDetails;
	
	//the project's list of features
	List<Feature> m_featureList;
	
	//the project's current status
	ProjectStatusEnum m_projectStatus;
	
	//TODO replace userID type from string to <USERID>?
	public void addFeature(String requestUserID, String Name, String description){
		
	}
}
