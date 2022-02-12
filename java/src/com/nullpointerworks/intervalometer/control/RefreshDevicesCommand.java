package com.nullpointerworks.intervalometer.control;

import java.util.ArrayList;
import java.util.List;

import com.nullpointerworks.intervalometer.control.interfaces.ActionCommand;
import com.nullpointerworks.intervalometer.control.interfaces.Command;
import com.nullpointerworks.intervalometer.model.config.Configuration;
import com.nullpointerworks.intervalometer.view.ApplicationView;

public class RefreshDevicesCommand implements Command 
{
	private Configuration mConfig;
	private ApplicationView vWindow;
	
	public RefreshDevicesCommand(ApplicationView v, Configuration c)
	{
		mConfig = c;
		vWindow = v;
	}
	
	@Override
	public void onCommand() 
	{
		
		List<String> list = mConfig.getRecentDevices();
		List<ActionCommand> cmds = new ArrayList<ActionCommand>();
		
		
		
		
		vWindow.setRecentDevices(list, cmds);
		
	}
	
}
