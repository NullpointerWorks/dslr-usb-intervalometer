package com.nullpointerworks.intervalometer.control.pui;

import com.nullpointerworks.intervalometer.control.interfaces.ActionCommand;
import com.nullpointerworks.intervalometer.model.IntervalProfile;
import com.nullpointerworks.intervalometer.view.ProfileJPanel;
import com.nullpointerworks.intervalometer.view.TimeTunerJDialog;
import com.nullpointerworks.util.Convert;

public class SetStartDelayCommand implements ActionCommand 
{
	private ProfileJPanel vProfile;
	private IntervalProfile mProfile;
	
	public SetStartDelayCommand(ProfileJPanel v, IntervalProfile m)
	{
		vProfile = v;
		mProfile = m;
	}
	
	@Override
	public void onCommand() 
	{
		
		
		TimeTunerJDialog vTuner = new TimeTunerJDialog("Start-up Delay");
		vTuner.setVisible(true);
		if (!vTuner.isAccepted()) return;

		String h = vTuner.getHoursInput();
		String m = vTuner.getMinutesInput();
		String s = vTuner.getSecondsInput();
		int hours = Convert.toInt(h);
		int minutes = Convert.toInt(m);
		int seconds = Convert.toInt(s);
		
		String text = hours + "h " + minutes +"m "+ seconds+"s";
		vProfile.setStartDelayText(text);
		
		
		
		
		
		int counter = seconds + (60 * minutes) + (3600 * hours);
		mProfile.setStartDelay(counter);
		
		
	}
	
}
