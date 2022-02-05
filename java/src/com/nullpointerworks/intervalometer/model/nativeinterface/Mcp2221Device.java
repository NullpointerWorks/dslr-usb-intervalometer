package com.nullpointerworks.intervalometer.model.nativeinterface;

public interface Mcp2221Device
{
	String getManufacturerDescriptor();
	String getProductDescriptor();
	String getSerialNumberDescriptor();
	String getFactorySerialNumber();
	void readVidPid();
	int getVid();
	int getPid();
	
	/**
	 * Set the communication speed for I2C/SMBus operations.
	 * @param speed
	 */
	void setSpeed(int speed);
	void setManufacturerDescriptor(String desc);
	void setProductDescriptor(String desc);
	void setSerialNumberDescriptor(String sn);
	void setVidPid(int v, int p);
	void setGPIOValue(GPIO io, boolean v);
	
	long getDeviceHandle();
	void closeConnection();
}
