package com.nullpointerworks.intervalometer.control.menubar;

import javax.swing.JOptionPane;

import com.nullpointerworks.intervalometer.control.interfaces.ActionCommand;
import com.nullpointerworks.intervalometer.control.interfaces.Command;
import com.nullpointerworks.intervalometer.model.profile.IntervalProfile;
import com.nullpointerworks.intervalometer.model.profile.ProfileManager;

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
			int opt = JOptionPane.showConfirmDialog(null, "Would you like to save the current profile?", "Unsaved Profile", JOptionPane.OK_CANCEL_OPTION);
			if (opt == JOptionPane.OK_OPTION)
			{
				
				
				
				
			}
			mProfileManager.setStoredProfile(null);
		}
		
		IntervalProfile mProfile = new IntervalProfile(false);
		mProfile.setProfileName("NewProfile");
		mProfileManager.setStoredProfile(mProfile);
		cShowProfileCommand.onCommand();
	}
}
