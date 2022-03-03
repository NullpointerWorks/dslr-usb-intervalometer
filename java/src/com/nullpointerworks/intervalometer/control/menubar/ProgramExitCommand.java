package com.nullpointerworks.intervalometer.control.menubar;

import com.nullpointerworks.intervalometer.control.interfaces.ActionCommand;
import com.nullpointerworks.intervalometer.model.DeviceManager;
import com.nullpointerworks.intervalometer.model.profile.ProfileManager;

public class ProgramExitCommand implements ActionCommand 
{
	private DeviceManager mDeviceManager;
	private ProfileManager mProfileManager;
	
	public ProgramExitCommand(DeviceManager devm, ProfileManager prom)
	{
		mDeviceManager = devm;
		mProfileManager = prom;
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
		
		// save unsaved profile
		if (mProfileManager.hasProfile())
		{
			
			
			// TODO
		}
		
		System.exit(0);
	}
}
