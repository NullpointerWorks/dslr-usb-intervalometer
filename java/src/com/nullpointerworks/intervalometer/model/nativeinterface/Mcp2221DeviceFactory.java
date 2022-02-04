package com.nullpointerworks.intervalometer.model.nativeinterface;

import com.microchip.mcp2221.Constants;
import com.microchip.mcp2221.HidFeatures;

public final class Mcp2221DeviceFactory 
{
	private final Mcp2221NativeInterface chip;
	
	private int DEFAULT_VID = 0x04D8;
	private int DEFAULT_PID = 0x00DD;
    
	private int result = 0;
	private String libVersion;
	
	public Mcp2221DeviceFactory()
	{
        chip = new HidFeatures();
        
        result = chip.Mcp2221_LoadDll();
        if (result != Constants.E_NO_ERR) 
        {
            System.err.println("!!! Load DLL: " + result);
            return;
        }
        
        libVersion = chip.Mcp2221_GetLibraryVersion();
        result = chip.Mcp2221_GetLastError();
        if (result != Constants.E_NO_ERR) 
        {
            System.err.println("!!! Get Library Version: " + result);
            return;
        }
        
        System.out.println("Library version: " + libVersion);
	}
	
	/**
	 * 
	 * @return
	 */
	public int getNumberConnectedDevices()
	{
        int noOfDev = chip.Mcp2221_GetConnectedDevices(DEFAULT_VID, DEFAULT_PID);
        if (result != Constants.E_NO_ERR) 
        {
            System.err.println("!!! Error when retrieving the number of connected devices!");
        	return -1;
        }
        return noOfDev;
	}
	
	/**
	 * 
	 * @param sn
	 * @return
	 */
	public IMcp2221Device getDeviceBySerialNumber(String sn)
	{
		long mcpHandle = chip.Mcp2221_OpenBySN(DEFAULT_VID, DEFAULT_PID, sn);
		
        result = chip.Mcp2221_GetLastError();
        if (result != Constants.E_NO_ERR) 
        {
            System.err.println("!!! Open connection by serial number for device: " + result);
            return null;
        }
		
		return new Mcp2221Device(chip, mcpHandle);
	}
}
