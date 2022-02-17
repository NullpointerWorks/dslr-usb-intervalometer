package com.nullpointerworks.intervalometer.control.pui;

import com.nullpointerworks.intervalometer.control.interfaces.DocumentCommand;
import com.nullpointerworks.intervalometer.model.profile.IntervalProfile;
import com.nullpointerworks.intervalometer.view.ProfileJPanel;

public class NotesModificationCommand implements DocumentCommand 
{
	private IntervalProfile mProfile;
	private ProfileJPanel vPanel;
	
	public NotesModificationCommand(ProfileJPanel v, IntervalProfile m)
	{
		mProfile = m;
		vPanel = v;
	}
	
	@Override
	public synchronized void onCommand() 
	{
		mProfile.setProfileNotes( vPanel.getProfileNotes() );
	}
}
