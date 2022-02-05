package com.nullpointerworks.intervalometer.model.nativeinterface;

import com.microchip.mcp2221.Constants;

public class Mcp2221Device implements IMcp2221Device 
{
	private final Mcp2221NativeInterface nativeInterface;
	private final long devHandle;
	
	private byte gpioValues[];
	private int vid[] = new int[1];
	private int pid[] = new int[1];
	
	public Mcp2221Device(Mcp2221NativeInterface chip, long handle)
	{
		nativeInterface = chip;
		devHandle = handle;
		
		vid[0] = 0x04D8; // defaults
	    pid[0] = 0x00DD;
		
		gpioValues = new byte[4];
	    gpioValues[0] = 0;
	    gpioValues[1] = 0;
	    gpioValues[2] = 0;
	    gpioValues[3] = 0;
	}
	
	// ========================================================================
	// GETTERS
	// ========================================================================
	
	public String getManufacturerDescriptor()
	{
		String desc = new String();
		desc = nativeInterface.Mcp2221_GetManufacturerDescriptor(devHandle);
        
        int result = nativeInterface.Mcp2221_GetLastError();
        if (result != Constants.E_NO_ERR) 
        {
            System.err.println("!!! Get manufacturer descriptor for device: " + result);
        }
        
        return desc;
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
	public String getSerialNumberDescriptor()
	{
		String sn = new String();
        sn = nativeInterface.Mcp2221_GetSerialNumberDescriptor(devHandle);
        
        int result = nativeInterface.Mcp2221_GetLastError();
        if (result != Constants.E_NO_ERR) 
        {
            System.out.println("!!! Get serial number descriptor for device: " + result);
            return "";
        }
        
        return sn;
	}
	
	@Override
	public String getFactorySerialNumber()
	{
		String sn = new String();
        sn = nativeInterface.Mcp2221_GetFactorySerialNumber(devHandle);
        
        int result = nativeInterface.Mcp2221_GetLastError();
        if (result != Constants.E_NO_ERR) 
        {
            System.out.println("!!! Get factory serial number for device: " + result);
            return "";
        }
        
        return sn;
	}
	
	
	
	
	
	
	// ========================================================================
	// SETTERS
	// ========================================================================
	
	
	public void setSpeed(int speed)
	{
		if (speed < 46875) speed = 46875; // minimum
		if (speed < 500000) speed = 500000; // maximum
		
		int result = nativeInterface.Mcp2221_SetSpeed(devHandle, speed);
        if (result != Constants.E_NO_ERR) 
        {
            System.err.println("!!! Set min value for speed: " + result);
        }
        
	}
	
	public void setManufacturerDescriptor(String desc)
	{
		String temp = new String();
		temp = desc;
		
        int result = nativeInterface.Mcp2221_SetManufacturerDescriptor(devHandle, temp);
        if (result != Constants.E_NO_ERR)
        {
            System.err.println("!!! Set manufacturer descriptor for device: " + result);
        }
	}
	
	public void setProductDescriptor(String desc)
	{
		String temp = new String();
		temp = desc;
		
        int result = nativeInterface.Mcp2221_SetProductDescriptor(devHandle, temp);
        if (result != Constants.E_NO_ERR)
        {
            System.err.println("!!! Set product descriptor for device: " + result);
        }
	}
	
	public void setSerialNumberDescriptor(String sn)
	{
        String temp;
        temp = sn;
		
        int result = nativeInterface.Mcp2221_SetSerialNumberDescriptor(devHandle, temp);
        if (result != Constants.E_NO_ERR)
        {
            System.err.println("!!! Set serial number descriptor for device: " + result);
        }
	}
	
	
	
	
	
	
	
	
	
	@Override
	public void setGPIOValue(GPIO io, boolean v)
	{
		gpioValues[ io.ordinal() ] = (byte) ( (v)?1:0 );
        int result = nativeInterface.Mcp2221_SetGpioValues(devHandle, gpioValues);
        if (result != Constants.E_NO_ERR) 
        {
            System.out.println("!!! Set GPIO values for device: " + result);
        }
	}
	
	// ========================================================================
	// CONTROL
	// ========================================================================
	
	@Override
	public long getDeviceHandle()
	{
		return devHandle;
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
