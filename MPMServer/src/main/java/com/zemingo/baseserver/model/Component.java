package com.zemingo.baseserver.model;

public abstract class Component {

//members:
	
	//Component's name
	private String m_Name;
	
	//Component's description
	private String m_Description;
	
	//compont
	private Progress m_Progress;

//methods:
	
	//calculate the progress of the component
	//TODO - decide returning value (boolean,Progress)
	abstract void calcProgress();


	
	
}
