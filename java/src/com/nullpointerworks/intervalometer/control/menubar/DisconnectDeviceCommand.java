package com.nullpointerworks.intervalometer.control.menubar;

import com.nullpointerworks.intervalometer.control.interfaces.ActionCommand;
import com.nullpointerworks.intervalometer.model.DeviceManager;
import com.nullpointerworks.intervalometer.view.ApplicationView;

public class DisconnectDeviceCommand implements ActionCommand 
{
	private DeviceManager mDeviceManager;
	private ApplicationView vWindow;
	
	public DisconnectDeviceCommand(ApplicationView v, DeviceManager devm)
	{
		vWindow = v;
		mDeviceManager = devm;
	}
	
	@Override
	public void onCommand() 
	{
		if (!mDeviceManager.hasDevice()) return;
		
		mDeviceManager.getStoredDevice().closeConnection();
		mDeviceManager.setStoredDevice(null);
		
		vWindow.setSerialNumber("");
		vWindow.setConnected(false);
	}
}
