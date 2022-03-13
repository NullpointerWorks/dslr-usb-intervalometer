package com.nullpointerworks.intervalometer.control.menubar;

import com.nullpointerworks.intervalometer.control.interfaces.ActionCommand;
import com.nullpointerworks.intervalometer.control.interfaces.Command;
import com.nullpointerworks.intervalometer.model.config.Configuration;

public class ClearProHistoryCommand implements ActionCommand 
{
	private Configuration mConfig;
	private Command cRefreshRecentProfiles;
	
	public ClearProHistoryCommand(Command refresh, Configuration config)
	{
		mConfig = config;
		cRefreshRecentProfiles = refresh;
	}
	
	@Override
	public void onCommand() 
	{
		mConfig.clearRecentProfiles();
		cRefreshRecentProfiles.onCommand();
	}
}
