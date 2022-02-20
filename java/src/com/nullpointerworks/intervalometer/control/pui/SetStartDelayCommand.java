package com.nullpointerworks.intervalometer.control.pui;

import javax.swing.JDialog;

import com.nullpointerworks.intervalometer.control.interfaces.ActionCommand;
import com.nullpointerworks.intervalometer.view.TimeTunerJDialog;

public class SetStartDelayCommand implements ActionCommand 
{
	
	public SetStartDelayCommand()
	{
		
		
	}
	
	@Override
	public void onCommand() 
	{
		
		
		JDialog vTuner = new TimeTunerJDialog("Start-up Delay");
		
		vTuner.setVisible(true);
		
		
		
	}
	
}
