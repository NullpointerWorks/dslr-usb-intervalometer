package com.nullpointerworks.intervalometer.control.updaters;

import com.nullpointerworks.intervalometer.control.interfaces.Command;
import com.nullpointerworks.intervalometer.model.profile.IntervalProfile;
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
		
		text = getTimeText( mProfile.getExposureTime() );
		vProfile.setExposureTimeText(text);
		
		text = getTimeText( mProfile.getBetweenDelay() );
		vProfile.setBetweenDelayText(text);
		
		text = mProfile.getExposures() + "";
		vProfile.setExposuresText(text);
	}
	
	private String getTimeText(long sdelay)
	{
		long hours = sdelay / 3600;
		sdelay = sdelay % 3600;
		long mins = sdelay / 60;
		sdelay = sdelay % 60;
		long secs = sdelay;
		return hours + "h " + mins +"m "+ secs+"s";
	}

}
