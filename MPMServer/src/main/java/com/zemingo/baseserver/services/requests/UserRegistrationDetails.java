package com.zemingo.baseserver.services.requests;

import javax.xml.bind.annotation.XmlRootElement;

import com.wordnik.swagger.annotations.ApiModelProperty;

@XmlRootElement
public class UserRegistrationDetails {
	@ApiModelProperty(required = true)
	public String username;
	@ApiModelProperty(required = true)
	public String firstName;
	@ApiModelProperty(required = true)
	public String lastName;
	@ApiModelProperty(required = true)
	public String password;
	@ApiModelProperty(required = true)
	public String emailAddress;	
}
