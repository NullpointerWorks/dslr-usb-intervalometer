package com.nullpointerworks.intervalometer.control;

import com.nullpointerworks.intervalometer.control.interfaces.ActionCommand;
import com.nullpointerworks.intervalometer.model.DeviceManager;
import com.nullpointerworks.intervalometer.model.ProfileManager;
import com.nullpointerworks.intervalometer.model.profile.IntervalProfile;
import com.nullpointerworks.intervalometer.view.ApplicationView;
import com.nullpointerworks.intervalometer.view.ProfileJPanel;

public class NewProfileCommand implements ActionCommand 
{
	private ApplicationView vWindow;
	private ProfileManager mProfileManager;
	
	public NewProfileCommand(ApplicationView v, ProfileManager pm)
	{
		vWindow = v;
		mProfileManager = pm;
		
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
		ProfileJPanel vProfile = new ProfileJPanel();
		
		
		mProfileManager.setStoredProfile(mProfile);
		vWindow.setDisplayTab("* New Profile", vProfile);
	}
}
