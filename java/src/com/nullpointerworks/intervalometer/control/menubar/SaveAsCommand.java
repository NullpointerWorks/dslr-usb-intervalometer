package com.nullpointerworks.intervalometer.control.menubar;

import com.nullpointerworks.intervalometer.control.interfaces.ActionCommand;
import com.nullpointerworks.intervalometer.control.interfaces.Command;
import com.nullpointerworks.intervalometer.model.profile.ProfileManager;

public class SaveAsCommand implements ActionCommand 
{
	private ProfileManager mProfileManager;
	private Command cSaveProfile;
	
	public SaveAsCommand(ProfileManager pm, Command sc)
	{
		mProfileManager = pm;
		cSaveProfile = sc;
	}
	
	@Override
	public void onCommand() 
	{
		if (mProfileManager.hasProfile())
		{
			var profile = mProfileManager.getStoredProfile();
			profile.isFromFile(false);
			cSaveProfile.onCommand();
			profile.isFromFile(true);
		}
	}
}
