package com.zemingo.baseserver.services.requests;

import javax.xml.bind.annotation.XmlRootElement;

import com.wordnik.swagger.annotations.ApiModelProperty;

@XmlRootElement
public class UpdateDeviceRequest extends BaseRequest{
	@ApiModelProperty(required = true)
	public DeviceDetailsForUpdate deviceDetails;
}
