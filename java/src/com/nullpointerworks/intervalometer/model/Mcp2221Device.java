package com.nullpointerworks.intervalometer.model;

import com.microchip.mcp2221.Constants;
import com.microchip.mcp2221.HidFeatures;

public class Mcp2221Device implements IMcp2221Device 
{
	private final HidFeatures nativeInterface;
	private final long devHandle;
	
	public Mcp2221Device(HidFeatures chip, long handle)
	{
		nativeInterface = chip;
		devHandle = handle;
	}
	
	@Override
	public long getDeviceHandle()
	{
		return devHandle;
	}
	
	public String getProductDescriptor()
	{
		String desc = new String();
		desc = nativeInterface.Mcp2221_GetProductDescriptor(devHandle);
        
        int result = nativeInterface.Mcp2221_GetLastError();
        if (result != Constants.E_NO_ERR) 
        {
            System.out.println("!!! Get product descriptor for device: " + result);
        }
        
        return desc;
	}
	
	public void closeConnection()
	{
        int result = nativeInterface.Mcp2221_Close(devHandle);
        if (result != Constants.E_NO_ERR) 
        {
            System.out.println("!!! Close connection for device: " + result);
        }
	}
}
