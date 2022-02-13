package com.nullpointerworks.intervalometer.control;

import com.nullpointerworks.intervalometer.control.interfaces.ActionCommand;
import com.nullpointerworks.intervalometer.model.DeviceManager;

public class ProgramExitCommand implements ActionCommand 
{
	private DeviceManager mDeviceManager;
	
	
	public ProgramExitCommand(DeviceManager devm)
	{
		mDeviceManager = devm;
		
	}
	
	@Override
	public void onCommand() 
	{
		// properly close the connection
		if (mDeviceManager.hasDevice())
		{
			mDeviceManager.getStoredDevice().closeConnection();
			mDeviceManager.setStoredDevice(null);
		}
		
		
		
		System.exit(0);
	}
}
