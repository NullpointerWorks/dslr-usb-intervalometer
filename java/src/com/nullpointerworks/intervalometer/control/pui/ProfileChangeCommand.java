package com.nullpointerworks.intervalometer.control.pui;

import com.nullpointerworks.intervalometer.control.interfaces.Command;
import com.nullpointerworks.intervalometer.view.ApplicationView;

public class ProfileChangeCommand implements Command 
{
	private ApplicationView vWindow;
	
	public ProfileChangeCommand(ApplicationView v)
	{
		vWindow = v;
	}
	
	@Override
	public void onCommand() 
	{
		
		String title = vWindow.getDisplayTabTitle();
		if (!title.startsWith("* ")) title = "* "+title;
		vWindow.setDisplayTabTitle( title );
		
	}
	
}
