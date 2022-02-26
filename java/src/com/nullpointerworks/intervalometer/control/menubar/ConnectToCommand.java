package com.nullpointerworks.intervalometer.control.menubar;

import com.nullpointerworks.intervalometer.control.interfaces.ActionCommand;
import com.nullpointerworks.intervalometer.control.interfaces.Command;
import com.nullpointerworks.intervalometer.model.DeviceManager;
import com.nullpointerworks.intervalometer.model.config.Configuration;
import com.nullpointerworks.intervalometer.model.nativeinterface.Mcp2221Device;
import com.nullpointerworks.intervalometer.model.nativeinterface.Mcp2221DeviceFactory;
import com.nullpointerworks.intervalometer.view.ApplicationView;
import com.nullpointerworks.intervalometer.view.ConnectToJDialog;

public class ConnectToCommand implements ActionCommand 
{
	private ApplicationView vWindow;
	private Mcp2221DeviceFactory mFactory;
	private DeviceManager mDeviceManager;
	private Configuration mConfig;
	private Command cRefreshRecentDevices;
	
	public ConnectToCommand(ApplicationView appv, 
							Mcp2221DeviceFactory factory, 
							DeviceManager manager,
							Configuration cnfg,
							Command refresh)
	{
		vWindow = appv;
		mFactory = factory;
		mDeviceManager = manager;
		mConfig = cnfg;
		cRefreshRecentDevices = refresh;
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
		if (sn.length() < 1)
		{
			// error
			return; // no s/n given
		}
		
		if (mDeviceManager.hasDevice())
		{
			mDeviceManager.getStoredDevice().closeConnection();
			mDeviceManager.setStoredDevice(null);
		}
		
		Mcp2221Device dev = mFactory.getDeviceBySerialNumber(sn);
		if (dev == null)
		{
			// error
			vWindow.setSerialNumber("");
			vWindow.setConnected(false);
			return;
		}
		
		mConfig.setRecentDevice(sn);
		cRefreshRecentDevices.onCommand();
		
		mDeviceManager.setStoredDevice(dev);
		vWindow.setSerialNumber(dev.getSerialNumberDescriptor());
		vWindow.setConnected(true);
	}
}
