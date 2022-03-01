package com.nullpointerworks.intervalometer.control.pui;

import com.nullpointerworks.intervalometer.control.interfaces.ActionCommand;
import com.nullpointerworks.intervalometer.model.DeviceManager;
import com.nullpointerworks.intervalometer.model.nativeinterface.Mcp2221Device;
import com.nullpointerworks.intervalometer.view.ProfileJPanel;

public class StartStopCommand implements ActionCommand 
{
	private DeviceManager mDeviceManager;
	private ProfileJPanel vProfile;
	private boolean started;
	
	public StartStopCommand(ProfileJPanel p, DeviceManager dm)
	{
		mDeviceManager = dm;
		vProfile = p;
		started = false;
	}
	
	@Override
	public synchronized void onCommand() 
	{
		Mcp2221Device device = mDeviceManager.getStoredDevice();
		if (!started)
		{
			
			
			
		}
		else
		{
			
			
			
		}
		
	}
	

}
