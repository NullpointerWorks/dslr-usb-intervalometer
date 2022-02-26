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
		String text = getTimeText( mProfile.getStartDelay() );
		vProfile.setStartDelayText(text);
		
		
		
		
		
		
		
	}
	
	private String getTimeText(int sdelay)
	{
		int hours = sdelay / 3600;
		sdelay = sdelay % 3600;
		int mins = sdelay / 60;
		sdelay = sdelay % 60;
		int secs = sdelay;
		return hours + "h " + mins +"m "+ secs+"s";
	}

}
