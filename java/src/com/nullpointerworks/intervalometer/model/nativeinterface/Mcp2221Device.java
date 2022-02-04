package com.nullpointerworks.intervalometer.model.nativeinterface;

import com.microchip.mcp2221.Constants;

public class Mcp2221Device implements IMcp2221Device 
{
	private final Mcp2221NativeInterface nativeInterface;
	private final long devHandle;
	
	private byte gpioValues[];
	
	public Mcp2221Device(Mcp2221NativeInterface chip, long handle)
	{
		nativeInterface = chip;
		devHandle = handle;
		
		gpioValues = new byte[4];
	    gpioValues[0] = 0;
	    gpioValues[1] = 0;
	    gpioValues[2] = 0;
	    gpioValues[3] = 0;
	}
	
	@Override
	public long getDeviceHandle()
	{
		return devHandle;
	}
	
	@Override
	public String getProductDescriptor()
	{
		String desc = new String();
		desc = nativeInterface.Mcp2221_GetProductDescriptor(devHandle);
        
        int result = nativeInterface.Mcp2221_GetLastError();
        if (result != Constants.E_NO_ERR) 
        {
            System.err.println("!!! Get product descriptor for device: " + result);
        }
        
        return desc;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	@Override
	public void closeConnection()
	{
        int result = nativeInterface.Mcp2221_Close(devHandle);
        if (result != Constants.E_NO_ERR) 
        {
            System.err.println("!!! Close connection for device: " + result);
        }
	}
}
