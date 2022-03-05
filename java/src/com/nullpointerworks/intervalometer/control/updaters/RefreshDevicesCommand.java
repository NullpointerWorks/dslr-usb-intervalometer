package com.nullpointerworks.intervalometer.control.updaters;

import java.util.ArrayList;
import java.util.List;

import com.nullpointerworks.intervalometer.control.AutoConnectCommand;
import com.nullpointerworks.intervalometer.control.interfaces.ActionCommand;
import com.nullpointerworks.intervalometer.control.interfaces.Command;
import com.nullpointerworks.intervalometer.model.DeviceManager;
import com.nullpointerworks.intervalometer.model.config.Configuration;
import com.nullpointerworks.intervalometer.model.nativeinterface.Mcp2221DeviceFactory;
import com.nullpointerworks.intervalometer.view.ApplicationView;

public class RefreshDevicesCommand implements Command 
{
	private Configuration mConfig;
	private ApplicationView vWindow;
	private Mcp2221DeviceFactory mFactory;
	private DeviceManager mDeviceManager;
	
	public RefreshDevicesCommand(ApplicationView v, Configuration c, Mcp2221DeviceFactory fac, DeviceManager devm)
	{
		mConfig = c;
		vWindow = v;
		mFactory = fac;
		mDeviceManager = devm;
	}
	
	@Override
	public void onCommand() 
	{
		List<String> list = mConfig.getRecentDevices();
		List<ActionCommand> cmds = new ArrayList<ActionCommand>();
		
		for (String sn : list)
		{
			ActionCommand c = new AutoConnectCommand(sn, vWindow, mFactory, mDeviceManager);
			cmds.add(c);
		}
		
		vWindow.setRecentDevices(list, cmds);
		
	}
}
