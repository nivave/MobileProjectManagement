package com.zemingo.baseserver.services.requests;

import javax.xml.bind.annotation.XmlRootElement;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@XmlRootElement
@ApiModel
public class LoginRequest {
	
	@ApiModelProperty(position = 4, required = true)
	public DeviceDetails deviceDetails;
	@ApiModelProperty(position = 1, required = false)
	public String username;
	@ApiModelProperty(position = 2, required = false)
	public String password;
	@ApiModelProperty(position = 3, required = false, 
			value = "When is specified all the data that associate with the current ‘unregister’ user will be copied to the new user. ")
	public String authToken;
}
