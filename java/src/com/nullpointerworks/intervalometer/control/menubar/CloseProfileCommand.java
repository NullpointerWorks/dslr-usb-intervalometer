package com.nullpointerworks.intervalometer.control.menubar;

import javax.swing.JOptionPane;

import com.nullpointerworks.intervalometer.control.interfaces.ActionCommand;
import com.nullpointerworks.intervalometer.control.interfaces.Command;
import com.nullpointerworks.intervalometer.model.profile.ProfileManager;
import com.nullpointerworks.intervalometer.view.ApplicationView;

public class CloseProfileCommand implements ActionCommand 
{
	private ApplicationView vWindow;
	private ProfileManager mProfileManager;
	private Command cSaveProfileCommand;
	
	public CloseProfileCommand(ApplicationView v, ProfileManager pm, Command csp)
	{
		vWindow = v;
		mProfileManager = pm;
		cSaveProfileCommand = csp;
	}
	
	@Override
	public void onCommand() 
	{
		if (!mProfileManager.hasProfile()) return;
		if (!mProfileManager.getStoredProfile().isSaved())
		{
			int opt = JOptionPane.showConfirmDialog(null, "Would you like to save the current profile?", "Unsaved Profile", JOptionPane.OK_CANCEL_OPTION);
			if (opt == JOptionPane.OK_OPTION)
			{
				cSaveProfileCommand.onCommand();
			}
			mProfileManager.setStoredProfile(null);
		}
		
		vWindow.clearDisplayTab();
		mProfileManager.setStoredProfile(null);
		vWindow.setSaveEnabled(false);
		vWindow.setSaveAsEnabled(false);
		vWindow.setCloseEnabled(false);
	}
}
