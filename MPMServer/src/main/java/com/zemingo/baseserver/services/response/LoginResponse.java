package com.zemingo.baseserver.services.response;

import com.wordnik.swagger.annotations.ApiModelProperty;

public class LoginResponse {
		
	@ApiModelProperty(required = true)
	public String authToken;
	
	public LoginResponse(String authToken){			
		this.authToken = authToken;
	}
}
