package com.nullpointerworks.intervalometer.control.updaters;

import java.util.ArrayList;
import java.util.List;

import com.nullpointerworks.intervalometer.control.AutoLoadCommand;
import com.nullpointerworks.intervalometer.control.interfaces.ActionCommand;
import com.nullpointerworks.intervalometer.control.interfaces.Command;
import com.nullpointerworks.intervalometer.model.config.Configuration;
import com.nullpointerworks.intervalometer.view.ApplicationView;

public class RefreshProfilesCommand implements Command 
{
	private ApplicationView vWindow;
	private Configuration mConfig;
	
	public RefreshProfilesCommand(ApplicationView v, Configuration c)
	{
		vWindow = v;
		mConfig = c;
	}
	
	@Override
	public void onCommand() 
	{
		List<String> list = mConfig.getRecentProfiles();
		List<ActionCommand> cmds = new ArrayList<ActionCommand>();
		
		for (String p : list)
		{
			ActionCommand c = new AutoLoadCommand(p, vWindow);
			cmds.add(c);
		}
		
		vWindow.setRecentProfiles(list, cmds);
		
	}
}
