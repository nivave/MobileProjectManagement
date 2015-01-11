package com.zemingo.baseserver.services.requests;

import javax.xml.bind.annotation.XmlRootElement;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@XmlRootElement
@ApiModel
public class RegisterUserRequest {
	
	@ApiModelProperty(required = true)
	public DeviceDetails deviceDetails;
	@ApiModelProperty(required = true)
	public UserRegistrationDetails userRegistrationDetails;
	@ApiModelProperty(required = false, 
			value = "When is specified all the data that associate with the current ‘unregister’ user will be copied to the new user. ")
	public String authToken;
}
