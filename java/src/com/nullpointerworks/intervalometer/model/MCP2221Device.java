package com.nullpointerworks.intervalometer.model;

public class MCP2221Device implements IMCP2221Device 
{
	private final long devHandle;
	
	public MCP2221Device(long handle)
	{
		devHandle = handle;
	}
	
	public long getDeviceHandle()
	{
		return devHandle;
	}
	
	
	
	
}
