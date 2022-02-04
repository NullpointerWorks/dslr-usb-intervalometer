package com.nullpointerworks.intervalometer.model.nativeinterface;

public interface IMcp2221Device
{
	long getDeviceHandle();
	String getProductDescriptor();
	String getSerialNumber();
	
	
	
	void setGPIOValue(GPIO io, boolean v);
	
	void closeConnection();
}
