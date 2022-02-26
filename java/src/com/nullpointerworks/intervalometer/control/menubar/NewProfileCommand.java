package com.nullpointerworks.intervalometer.control.menubar;

import com.nullpointerworks.intervalometer.control.interfaces.ActionCommand;
import com.nullpointerworks.intervalometer.control.interfaces.Command;
import com.nullpointerworks.intervalometer.model.IntervalProfile;
import com.nullpointerworks.intervalometer.model.ProfileManager;

public class NewProfileCommand implements ActionCommand 
{
	private ProfileManager mProfileManager;
	private Command cShowProfileCommand;
	
	public NewProfileCommand(Command spc, ProfileManager pm)
	{
		mProfileManager = pm;
		cShowProfileCommand = spc;
	}
	
	@Override
	public void onCommand() 
	{
		if (mProfileManager.hasProfile())
		{
			// save changes to previous profile
			// clear it's data
			// TODO
			mProfileManager.setStoredProfile(null);
		}
		
		IntervalProfile mProfile = new IntervalProfile(false);
		mProfile.setProfileName("New Profile");
		mProfileManager.setStoredProfile(mProfile);
		cShowProfileCommand.onCommand();
	}
}
