package com.zemingo.baseserver.services.response;

import com.zemingo.baseserver.model.User;

public class VerifyRegistrationResponse {
	public String userToken;
	public User userDetails;
	
	public VerifyRegistrationResponse(String userToken, User user){
		this.userToken = userToken;		
		userDetails = user;
	}
}
