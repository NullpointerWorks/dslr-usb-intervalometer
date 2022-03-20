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
	private Command cSaveProfileCommand;
	
	public NewProfileCommand(Command spc, Command csp, ProfileManager pm)
	{
		mProfileManager = pm;
		cShowProfileCommand = spc;
		cSaveProfileCommand = csp;
	}
	
	@Override
	public void onCommand() 
	{
		if (mProfileManager.hasProfile())
		if (!mProfileManager.getStoredProfile().isSaved())
		{
			int opt = JOptionPane.showConfirmDialog(null, "Would you like to save the current profile?", "Unsaved Profile", JOptionPane.OK_CANCEL_OPTION);
			if (opt == JOptionPane.OK_OPTION)
			{
				cSaveProfileCommand.onCommand();
			}
			mProfileManager.setStoredProfile(null);
		}
		
		IntervalProfile mProfile = new IntervalProfile(false);
		mProfile.setSaved(true); // set a new default profile as saved so you only get a notification when it's changed
		mProfile.setProfileName("NewProfile");
		mProfileManager.setStoredProfile(mProfile);
		cShowProfileCommand.onCommand();
	}
}
