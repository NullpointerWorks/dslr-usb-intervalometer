package com.nullpointerworks.intervalometer.control;

import com.nullpointerworks.intervalometer.control.interfaces.ActionCommand;
import com.nullpointerworks.intervalometer.model.DeviceManager;
import com.nullpointerworks.intervalometer.model.nativeinterface.Mcp2221Device;
import com.nullpointerworks.intervalometer.model.nativeinterface.Mcp2221DeviceFactory;
import com.nullpointerworks.intervalometer.view.ApplicationView;

public class AutoConnectCommand implements ActionCommand 
{
	private String serialNumber;
	private ApplicationView vWindow;
	private Mcp2221DeviceFactory mFactory;
	private DeviceManager mDeviceManager;
	
	public AutoConnectCommand(String sn, ApplicationView v, Mcp2221DeviceFactory fac, DeviceManager devm)
	{
		serialNumber = sn;
		vWindow = v;
		mFactory = fac;
		mDeviceManager = devm;
	}
	
	@Override
	public void onCommand() 
	{
		Mcp2221Device dev = mFactory.getDeviceBySerialNumber(serialNumber);
		if (dev == null)
		{
			// error
			vWindow.setSerialNumber("");
			vWindow.setConnected(false);
			return;
		}
		
		mDeviceManager.setStoredDevice(dev);
		vWindow.setSerialNumber(dev.getSerialNumberDescriptor());
		vWindow.setConnected(true);
	}
}
