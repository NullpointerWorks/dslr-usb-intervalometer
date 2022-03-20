package com.nullpointerworks.intervalometer.control.pui;

import com.nullpointerworks.intervalometer.control.interfaces.Command;
import com.nullpointerworks.intervalometer.model.profile.IntervalProfile;
import com.nullpointerworks.intervalometer.view.ApplicationView;

public class ProfileChangeCommand implements Command 
{
	private ApplicationView vWindow;
	private IntervalProfile mProfile;
	
	public ProfileChangeCommand(ApplicationView v, IntervalProfile p)
	{
		vWindow = v;
		mProfile = p;
	}
	
	@Override
	public void onCommand() 
	{
		String title = vWindow.getDisplayTabTitle();
		if (!title.startsWith("* ")) title = "* "+title;
		vWindow.setDisplayTabTitle( title );
		mProfile.setSaved(false);
	}
}
