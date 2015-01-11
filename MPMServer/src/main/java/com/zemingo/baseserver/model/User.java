package com.zemingo.baseserver.model;


public class User  {

	public String userName;
	public String password;





	//default constructor
	public User(){

	}	

	public User(String userName, String pass){
		this.userName = userName;
		this.password = pass;
	}
	
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return new StringBuffer("User Name: ").append(this.userName).append(" Password: ").append(this.password).toString();
	}




}
