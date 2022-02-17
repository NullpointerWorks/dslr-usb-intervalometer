package com.nullpointerworks.intervalometer.control.pui;

import com.nullpointerworks.intervalometer.control.interfaces.Command;
import com.nullpointerworks.intervalometer.control.interfaces.DocumentCommand;
import com.nullpointerworks.intervalometer.model.IntervalProfile;
import com.nullpointerworks.intervalometer.view.ProfileJPanel;

public class NotesModificationCommand implements DocumentCommand 
{
	private IntervalProfile mProfile;
	private ProfileJPanel vPanel;
	private Command cProfileChange;
	
	public NotesModificationCommand(Command cpc, ProfileJPanel v, IntervalProfile m)
	{
		cProfileChange = cpc;
		mProfile = m;
		vPanel = v;
	}
	
	@Override
	public synchronized void onCommand() 
	{
		mProfile.setProfileNotes( vPanel.getProfileNotes() );
		cProfileChange.onCommand();
	}
}
