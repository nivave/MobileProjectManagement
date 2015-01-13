package com.zemingo.baseserver.model;

import java.util.Map;


public class User  {

//members:
	
	private String m_name;
	
	private String m_userName;
	
	private String m_password;

	private DepartmentEnum m_department;

	private AccessRightsEnum m_accessRights;

	private Map<Integer,AccessRightsEnum> m_projectsToAccess;

//methods:
	

}
