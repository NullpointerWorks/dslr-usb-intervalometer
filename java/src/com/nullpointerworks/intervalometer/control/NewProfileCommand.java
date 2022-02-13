package com.nullpointerworks.intervalometer.control;

import com.nullpointerworks.intervalometer.control.interfaces.ActionCommand;
import com.nullpointerworks.intervalometer.model.DeviceManager;
import com.nullpointerworks.intervalometer.view.ApplicationView;
import com.nullpointerworks.intervalometer.view.ProfileJPanel;

public class NewProfileCommand implements ActionCommand 
{
	private ApplicationView vWindow;
	
	
	public NewProfileCommand(ApplicationView v)
	{
		vWindow = v;
		
		
	}
	
	@Override
	public void onCommand() 
	{
		
		
		
		ProfileJPanel vProfile = new ProfileJPanel();
		
		
		
		vWindow.setDisplayTab("* Unsaved Profile", vProfile);
		
		
		vWindow.setDisplayTabTitle("Test");
		
	}
}
