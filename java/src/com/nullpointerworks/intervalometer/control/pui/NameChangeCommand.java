package com.nullpointerworks.intervalometer.control.pui;

import com.nullpointerworks.intervalometer.control.interfaces.ActionCommand;
import com.nullpointerworks.intervalometer.control.interfaces.Command;
import com.nullpointerworks.intervalometer.model.profile.IntervalProfile;
import com.nullpointerworks.intervalometer.view.ApplicationView;
import com.nullpointerworks.intervalometer.view.ProfileJPanel;

public class NameChangeCommand implements ActionCommand 
{
	private Command cProfileChangeCommand;
	private ApplicationView vWindow;
	private IntervalProfile mProfile;
	private ProfileJPanel vProfile;
	
	public NameChangeCommand(IntervalProfile ip, Command c, ProfileJPanel pp, ApplicationView av)
	{
		cProfileChangeCommand = c;
		mProfile = ip;
		vProfile = pp;
		vWindow = av;
	}
	
	@Override
	public void onCommand() 
	{
		
		
		vWindow.setDisplayTabTitle(":D");
		
		
		
		cProfileChangeCommand.onCommand();
	}
}
