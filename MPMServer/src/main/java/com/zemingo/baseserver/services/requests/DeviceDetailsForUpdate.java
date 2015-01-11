package com.zemingo.baseserver.services.requests;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class DeviceDetailsForUpdate {	
	public String deviceId;
	public int osType;
	public int deviceType;
	public String deviceModel;
	public String osVersion;
	public String pnToken;
	public int pnType;
	public String timeZone;
	public String applicationVersion;
}
