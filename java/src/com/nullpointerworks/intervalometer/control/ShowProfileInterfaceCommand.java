package com.nullpointerworks.intervalometer.control;

import com.nullpointerworks.intervalometer.control.interfaces.ActionCommand;
import com.nullpointerworks.intervalometer.control.interfaces.Command;
import com.nullpointerworks.intervalometer.control.interfaces.DocumentCommand;
import com.nullpointerworks.intervalometer.control.pui.NameModificationCommand;
import com.nullpointerworks.intervalometer.control.pui.NotesModificationCommand;
import com.nullpointerworks.intervalometer.control.pui.ProfileChangeCommand;
import com.nullpointerworks.intervalometer.model.DeviceManager;
import com.nullpointerworks.intervalometer.model.IntervalProfile;
import com.nullpointerworks.intervalometer.model.ProfileManager;
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
		DocumentCommand cNameChangeCommand = new NameModificationCommand(cProfileChangeCommand, vProfile, mProfile);
		DocumentCommand cNotesChangeCommand = new NotesModificationCommand(cProfileChangeCommand, vProfile, mProfile);

		ActionCommand cSetStartDelay;
		ActionCommand cSetExposureTime;
		ActionCommand cSetTweenDelay;
		ActionCommand cStartSession;
		
		
		
		
		
		
		
		
		if (!mProfile.isFromFile())
		{
			vProfile.setNameChangeCommand(cNameChangeCommand);
			vProfile.setNotesChangeCommand(cNotesChangeCommand);
			vProfile.setStartUpDelayCommand(cSetStartDelay);
			vProfile.setExposureTimeCommand(cSetExposureTime);
			vProfile.setBetweenDelayCommand(cSetTweenDelay);
			vProfile.setStartSessionCommand(cStartSession);
		}
		
		vWindow.setSaveEnabled(true);
		vWindow.setSaveAsEnabled(false);
		vWindow.setCloseEnabled(false);
		vWindow.setDisplayTab(mProfile.getProfileName(), vProfile);
		vProfile.setProfileName(mProfile.getProfileName());
		vProfile.setProfileNotes(mProfile.getProfileNotes());
		
		
		if (mProfile.isFromFile())
		{
			vProfile.setNameChangeCommand(cNameChangeCommand);
			vProfile.setNotesChangeCommand(cNotesChangeCommand);
			vProfile.setStartUpDelayCommand(cSetStartDelay);
			vProfile.setExposureTimeCommand(cSetExposureTime);
			vProfile.setBetweenDelayCommand(cSetTweenDelay);
			vProfile.setStartSessionCommand(cStartSession);
		}
	}
}
