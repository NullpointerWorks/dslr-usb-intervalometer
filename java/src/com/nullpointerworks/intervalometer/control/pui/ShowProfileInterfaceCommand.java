package com.nullpointerworks.intervalometer.control.pui;

import com.nullpointerworks.intervalometer.control.interfaces.*;
import com.nullpointerworks.intervalometer.control.updaters.UpdateStartDelayCommand;
import com.nullpointerworks.intervalometer.model.DeviceManager;
import com.nullpointerworks.intervalometer.model.profile.IntervalProfile;
import com.nullpointerworks.intervalometer.model.profile.ProfileManager;
import com.nullpointerworks.intervalometer.view.ApplicationView;
import com.nullpointerworks.intervalometer.view.ProfileJPanel;

public class ShowProfileInterfaceCommand implements Command 
{
	private ApplicationView vWindow;
	private ProfileManager mProfileManager;
	private DeviceManager mDeviceManager;
	
	public ShowProfileInterfaceCommand(ApplicationView v, ProfileManager pm, DeviceManager dm)
	{
		vWindow = v;
		mProfileManager = pm;
		mDeviceManager = dm;
	}
	
	@Override
	public void onCommand() 
	{
		IntervalProfile mProfile = mProfileManager.getStoredProfile();
		ProfileJPanel vProfile = new ProfileJPanel();
		
		Command cProfileChangeCommand = new ProfileChangeCommand(vWindow);
		Command cUpdateProfileInterface = new UpdateStartDelayCommand(vProfile, mProfile);
		DocumentCommand cNameChangeCommand = new NameModificationCommand(cProfileChangeCommand, vProfile, mProfile);
		DocumentCommand cNotesChangeCommand = new NotesModificationCommand(cProfileChangeCommand, vProfile, mProfile);
		
		ActionCommand cSetStartDelay = new SetStartDelayCommand(mProfile, cProfileChangeCommand, cUpdateProfileInterface);
		ActionCommand cSetExposureTime = new SetExposureTimeCommand(mProfile, cProfileChangeCommand, cUpdateProfileInterface);
		ActionCommand cSetTweenDelay = new SetBetweenTimeCommand(mProfile, cProfileChangeCommand, cUpdateProfileInterface);
		ActionCommand cStartSession = new StartStopCommand(vProfile, mProfile, mDeviceManager);

		vProfile.setStartUpDelayCommand(cSetStartDelay);
		vProfile.setExposureTimeCommand(cSetExposureTime);
		vProfile.setBetweenDelayCommand(cSetTweenDelay);
		vProfile.setStartSessionCommand(cStartSession);
		
		// if this is a new profile (not form a file) 
		// set the change listeners before filling in info.
		// this makes the profile as unsaved, which makes sense for a new profile
		if (!mProfile.isFromFile())
		{
			vProfile.setNameChangeCommand(cNameChangeCommand);
			vProfile.setNotesChangeCommand(cNotesChangeCommand);
		}
		
		vWindow.setSaveEnabled(true);
		vWindow.setSaveAsEnabled(false);
		vWindow.setCloseEnabled(false);
		vWindow.setDisplayTab(mProfile.getProfileName(), vProfile);
		vProfile.setProfileName(mProfile.getProfileName());
		vProfile.setProfileNotes(mProfile.getProfileNotes());
		
		// otherwise set the change listeners after filling in information
		if (mProfile.isFromFile())
		{
			vProfile.setNameChangeCommand(cNameChangeCommand);
			vProfile.setNotesChangeCommand(cNotesChangeCommand);
		}
		
		cUpdateProfileInterface.onCommand();
	}
}
