package com.nullpointerworks.intervalometer.control.updaters;

import com.nullpointerworks.intervalometer.control.interfaces.Command;
import com.nullpointerworks.intervalometer.model.IntervalProfile;
import com.nullpointerworks.intervalometer.view.ProfileJPanel;

public class UpdateStartDelayCommand implements Command 
{
	private ProfileJPanel vProfile;
	private IntervalProfile mProfile;
	
	public UpdateStartDelayCommand(ProfileJPanel v, IntervalProfile m)
	{
		vProfile = v;
		mProfile = m;
	}
	
	@Override
	public void onCommand() 
	{
		int sdelay = mProfile.getStartDelay();
		int secs = sdelay % 60;
		int hours = sdelay / 3600;
		int mins = (sdelay-secs) / 60;
		
		String text = hours + "h " + mins +"m "+ secs+"s";
		vProfile.setStartDelayText(text);
		
		
	}

}
