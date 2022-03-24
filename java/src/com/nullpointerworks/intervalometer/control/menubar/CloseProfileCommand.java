package com.nullpointerworks.intervalometer.control.menubar;

import com.nullpointerworks.intervalometer.control.interfaces.ActionCommand;
import com.nullpointerworks.intervalometer.model.profile.ProfileManager;
import com.nullpointerworks.intervalometer.view.ApplicationView;

public class CloseProfileCommand implements ActionCommand 
{
	private ApplicationView vWindow;
	private ProfileManager mProfileManager;
	
	public CloseProfileCommand(ApplicationView v, ProfileManager pm)
	{
		vWindow = v;
		mProfileManager = pm;
	}
	
	@Override
	public void onCommand() 
	{
		if (!mProfileManager.hasProfile()) return;
		var profile = mProfileManager.getStoredProfile();
		if (!profile.isSaved())
		{
			
			
			
		}
		
		vWindow.clearDisplayTab();
		mProfileManager.setStoredProfile(null);
	}
}
