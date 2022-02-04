package com.nullpointerworks.intervalometer.model;

public interface IMcp2221Device
{
	
	long getDeviceHandle();
	
	String getProductDescriptor();
	
	
	
	
	
	void closeConnection();
	
}
