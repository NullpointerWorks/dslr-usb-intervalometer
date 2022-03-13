package com.nullpointerworks.intervalometer.control.pui;

import com.nullpointerworks.intervalometer.control.interfaces.ActionCommand;
import com.nullpointerworks.intervalometer.model.profile.IntervalProfile;
import com.nullpointerworks.intervalometer.view.ProfileJPanel;

public class NameChangeCommand implements ActionCommand 
{
	private IntervalProfile mProfile;
	private ProfileJPanel vProfile;
	
	public NameChangeCommand(IntervalProfile ip, ProfileJPanel pp)
	{
		mProfile = ip;
		vProfile = pp;
	}
	
	@Override
	public void onCommand() 
	{
		
		// TODO
		
		
		
	}
}
