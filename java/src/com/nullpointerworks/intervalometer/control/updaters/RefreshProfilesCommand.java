package com.nullpointerworks.intervalometer.control.updaters;

import java.util.ArrayList;
import java.util.List;

import com.nullpointerworks.intervalometer.control.AutoLoadCommand;
import com.nullpointerworks.intervalometer.control.interfaces.ActionCommand;
import com.nullpointerworks.intervalometer.control.interfaces.Command;
import com.nullpointerworks.intervalometer.model.config.Configuration;
import com.nullpointerworks.intervalometer.model.profile.ProfileManager;
import com.nullpointerworks.intervalometer.view.ApplicationView;

public class RefreshProfilesCommand implements Command 
{
	private ApplicationView vWindow;
	private Configuration mConfig;
	private ProfileManager mProfileManager;
	private Command cShowProfileCommand;
	private Command cSaveProfileCommand;
	
	public RefreshProfilesCommand(ApplicationView v, Configuration c, ProfileManager pm, Command spc, Command csp)
	{
		vWindow = v;
		mConfig = c;
		mProfileManager = pm;
		cShowProfileCommand = spc;
		cSaveProfileCommand = csp;
	}
	
	@Override
	public void onCommand() 
	{
		List<String> list = mConfig.getRecentProfiles();
		List<String> names = new ArrayList<String>();
		List<ActionCommand> cmds = new ArrayList<ActionCommand>();
		
		for (String p : list)
		{
			ActionCommand c = new AutoLoadCommand(p, mProfileManager, cShowProfileCommand, cSaveProfileCommand);
			String s = p.substring( p.lastIndexOf("/")+1, p.lastIndexOf(".") );
			
			names.add(s);
			cmds.add(c);
		}
		
		vWindow.setRecentProfiles(names, cmds);
	}
}
