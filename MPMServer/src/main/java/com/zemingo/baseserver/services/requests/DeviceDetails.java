package com.zemingo.baseserver.services.requests;

import javax.xml.bind.annotation.XmlRootElement;

import com.wordnik.swagger.annotations.ApiModelProperty;

@XmlRootElement
public class DeviceDetails {
	@ApiModelProperty(required = true)
	public String deviceId;
	@ApiModelProperty(required = true)
	public int osType;
	@ApiModelProperty(required = true)
	public int deviceType;
	@ApiModelProperty(required = true)
	public String deviceModel;
	@ApiModelProperty(required = true)
	public String osVersion;
	@ApiModelProperty(required = true)
	public String pnToken;
	@ApiModelProperty(required = true)
	public int pnType;
	@ApiModelProperty(required = true)
	public String timeZone;
	@ApiModelProperty(required = true)
	public String applicationVersion;
}
