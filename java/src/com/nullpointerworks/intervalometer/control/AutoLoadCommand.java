package com.nullpointerworks.intervalometer.control;

import com.nullpointerworks.intervalometer.control.interfaces.ActionCommand;
import com.nullpointerworks.intervalometer.model.DeviceManager;
import com.nullpointerworks.intervalometer.model.nativeinterface.Mcp2221Device;
import com.nullpointerworks.intervalometer.model.nativeinterface.Mcp2221DeviceFactory;
import com.nullpointerworks.intervalometer.view.ApplicationView;

public class AutoLoadCommand implements ActionCommand 
{
	private String profilePath;
	private ApplicationView vWindow;
	
	public AutoLoadCommand(String pp, ApplicationView v)
	{
		profilePath = pp;
		vWindow = v;
	}
	
	@Override
	public void onCommand() 
	{
		
		
		
		
	}
}
