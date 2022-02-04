package com.nullpointerworks.intervalometer.model.nativeinterface;

public interface IMcp2221Device
{
	
	long getDeviceHandle();
	
	String getProductDescriptor();
	
	
	
	
	
	void closeConnection();
	
}
