package com.nullpointerworks.intervalometer.control.pui;

import com.nullpointerworks.intervalometer.control.TakeExposuresCommand;
import com.nullpointerworks.intervalometer.control.interfaces.ActionCommand;
import com.nullpointerworks.intervalometer.control.interfaces.RunnableCommand;
import com.nullpointerworks.intervalometer.model.DeviceManager;
import com.nullpointerworks.intervalometer.model.IntervalProfile;
import com.nullpointerworks.intervalometer.model.nativeinterface.Mcp2221Device;
import com.nullpointerworks.intervalometer.view.ProfileJPanel;

public class StartStopCommand implements ActionCommand 
{
	private ProfileJPanel vProfile;
	private IntervalProfile mProfile;
	private DeviceManager mDeviceManager;
	
	private boolean started;
	private Thread t;
	
	public StartStopCommand(ProfileJPanel p, IntervalProfile i, DeviceManager dm)
	{
		mDeviceManager = dm;
		vProfile = p;
		mProfile = i;
		started = false;
	}
	
	@Override
	public synchronized void onCommand() 
	{
		Mcp2221Device device = mDeviceManager.getStoredDevice();
		if (!started)
		{
			RunnableCommand c = new TakeExposuresCommand(device);
			t = new Thread(c);
			t.start();
			started = true;
		}
		else
		{
			t.interrupt();
			started = false;
		}
	}
}
