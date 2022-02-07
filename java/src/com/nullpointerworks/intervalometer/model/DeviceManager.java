package com.nullpointerworks.intervalometer.model;

import com.nullpointerworks.intervalometer.model.nativeinterface.Mcp2221Device;

public class DeviceManager 
{
	private Mcp2221Device stored = null;
	public synchronized void setStoredDevice(Mcp2221Device dev) {stored = dev;}
	public synchronized Mcp2221Device getStoredDevice() {return stored;}
	public synchronized void clearStoredDevice() {setStoredDevice(null);}
	public synchronized boolean hasDevice() {return stored != null;}
}
