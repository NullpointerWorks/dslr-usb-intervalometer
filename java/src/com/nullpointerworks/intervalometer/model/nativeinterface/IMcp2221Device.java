package com.nullpointerworks.intervalometer.model.nativeinterface;

public interface IMcp2221Device
{
	String getManufacturerDescriptor();
	String getProductDescriptor();
	String getSerialNumberDescriptor();
	String getFactorySerialNumber();
	
	
	/**
	 * Set the communication speed for I2C/SMBus operations.
	 * @param speed
	 */
	void setSpeed(int speed);
	void setManufacturerDescriptor(String desc);
	void setProductDescriptor(String desc);
	void setSerialNumberDescriptor(String sn);
	
	void setGPIOValue(GPIO io, boolean v);
	
	
	long getDeviceHandle();
	void closeConnection();
}
