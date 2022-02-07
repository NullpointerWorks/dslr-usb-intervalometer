package com.nullpointerworks.intervalometer.control;

import com.nullpointerworks.intervalometer.control.interfaces.ActionCommand;
import com.nullpointerworks.intervalometer.model.DeviceManager;
import com.nullpointerworks.intervalometer.model.nativeinterface.Mcp2221Device;
import com.nullpointerworks.intervalometer.model.nativeinterface.Mcp2221DeviceFactory;
import com.nullpointerworks.intervalometer.view.ApplicationView;
import com.nullpointerworks.intervalometer.view.ConnectToJDialog;

public class ConnectToCommand implements ActionCommand 
{
	private ApplicationView vWindow;
	private Mcp2221DeviceFactory mFactory;
	private DeviceManager mDeviceManager;
	
	public ConnectToCommand(ApplicationView appv, 
							Mcp2221DeviceFactory factory, 
							DeviceManager manager)
	{
		vWindow = appv;
		mFactory = factory;
		mDeviceManager = manager;
	}
	
	@Override
	public void onCommand() 
	{
		ConnectToJDialog vDialog = new ConnectToJDialog();
		vDialog.setVisible(true);
		if (!vDialog.isAccepted())
		{
			return; // cancelled
		}
		
		String sn = vDialog.getSerialNumber();
		Mcp2221Device dev = mFactory.getDeviceBySerialNumber(sn);
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
