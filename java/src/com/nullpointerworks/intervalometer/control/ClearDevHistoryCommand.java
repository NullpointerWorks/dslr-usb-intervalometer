package com.nullpointerworks.intervalometer.control;

import com.nullpointerworks.intervalometer.control.interfaces.ActionCommand;
import com.nullpointerworks.intervalometer.control.interfaces.Command;
import com.nullpointerworks.intervalometer.model.config.Configuration;

public class ClearDevHistoryCommand implements ActionCommand 
{
	private Configuration mConfig;
	private Command cRefreshRecentDevices;
	
	public ClearDevHistoryCommand(Command refresh, Configuration config)
	{
		mConfig = config;
		cRefreshRecentDevices = refresh;
	}
	
	@Override
	public void onCommand() 
	{
		mConfig.clearRecentDevices();
		cRefreshRecentDevices.onCommand();
	}
}
