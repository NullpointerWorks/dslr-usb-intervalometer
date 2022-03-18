package com.nullpointerworks.intervalometer.control.pui;

import com.nullpointerworks.intervalometer.control.interfaces.ActionCommand;
import com.nullpointerworks.intervalometer.control.interfaces.Command;
import com.nullpointerworks.intervalometer.model.profile.IntervalProfile;
import com.nullpointerworks.intervalometer.view.ApplicationView;
import com.nullpointerworks.intervalometer.view.ChangeNameJDialog;

public class NameChangeCommand implements ActionCommand 
{
	private Command cProfileChangeCommand;
	private ApplicationView vWindow;
	private IntervalProfile mProfile;
	
	public NameChangeCommand(IntervalProfile ip, Command c, ApplicationView av)
	{
		cProfileChangeCommand = c;
		mProfile = ip;
		vWindow = av;
	}
	
	@Override
	public void onCommand() 
	{
		ChangeNameJDialog view = new ChangeNameJDialog();
		view.setNameText( mProfile.getProfileName() );
		view.setVisible(true);
		if (view.isAccepted())
		{
			final String name = view.getNameText();
			mProfile.setProfileName( name );
			vWindow.setDisplayTabTitle( name );
			cProfileChangeCommand.onCommand();
		}
	}
}
