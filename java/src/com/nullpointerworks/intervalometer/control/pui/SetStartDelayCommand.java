package com.nullpointerworks.intervalometer.control.pui;

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
		
		
		TimeTunerJDialog vTuner = new TimeTunerJDialog("Start-up Delay");
		vTuner.setVisible(true);
		if (!vTuner.isAccepted()) return;
		
		
		
		
		
		
	}
	
}
