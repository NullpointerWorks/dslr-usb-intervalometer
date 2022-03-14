package com.nullpointerworks.intervalometer.control.pui;

import com.nullpointerworks.intervalometer.control.interfaces.ActionCommand;
import com.nullpointerworks.intervalometer.model.profile.IntervalProfile;
import com.nullpointerworks.intervalometer.view.ApplicationView;
import com.nullpointerworks.intervalometer.view.ProfileJPanel;

public class NameChangeCommand implements ActionCommand 
{
	private ApplicationView vWindow;
	private IntervalProfile mProfile;
	private ProfileJPanel vProfile;
	
	public NameChangeCommand(IntervalProfile ip, ProfileJPanel pp, ApplicationView av)
	{
		mProfile = ip;
		vProfile = pp;
		vWindow = av;
	}
	
	@Override
	public void onCommand() 
	{
		System.out.println("changing");
		// TODO
		
		
		vWindow.setDisplayTabTitle(":D");
		
		
	}
}
