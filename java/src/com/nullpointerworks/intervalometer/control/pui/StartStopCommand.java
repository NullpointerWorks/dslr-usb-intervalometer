package com.nullpointerworks.intervalometer.control.pui;

import javax.swing.JOptionPane;

import com.nullpointerworks.intervalometer.control.TakeExposuresCommand;
import com.nullpointerworks.intervalometer.control.interfaces.*;
import com.nullpointerworks.intervalometer.model.DeviceManager;
import com.nullpointerworks.intervalometer.model.nativeinterface.Mcp2221Device;
import com.nullpointerworks.intervalometer.model.profile.IntervalProfile;
import com.nullpointerworks.intervalometer.view.ProfileJPanel;

public class StartStopCommand implements ActionCommand 
{
	private ProfileJPanel vProfile;
	private IntervalProfile mProfile;
	private DeviceManager mDeviceManager;
	
	private boolean started;
	private TakeExposuresCommand c;
	
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
		if (device == null) 
		{
			JOptionPane.showMessageDialog(vProfile, "Please connect to a device using the \"Program\" menu.", "No Device", JOptionPane.WARNING_MESSAGE);
			return; 
		}
		
		if (!device.isConnected())
		{
			JOptionPane.showMessageDialog(vProfile, "Please connect to a device using the \"Program\" menu.", "No Device", JOptionPane.WARNING_MESSAGE);
			return;
		}

		c = new TakeExposuresCommand(vProfile, mProfile, device);
		if (!started)
		{
			started = true;
			c.onCommand();
		}
		else
		{
			started = false;
			c.stop();
		}
		
		vProfile.setStartButtonState(started);
	}
}
