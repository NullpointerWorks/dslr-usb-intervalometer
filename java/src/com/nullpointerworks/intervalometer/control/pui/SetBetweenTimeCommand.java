package com.nullpointerworks.intervalometer.control.pui;

import com.nullpointerworks.intervalometer.control.interfaces.ActionCommand;
import com.nullpointerworks.intervalometer.control.interfaces.Command;
import com.nullpointerworks.intervalometer.model.profile.IntervalProfile;
import com.nullpointerworks.intervalometer.view.TimeTunerJDialog;
import com.nullpointerworks.util.Convert;

public class SetBetweenTimeCommand implements ActionCommand 
{
	private IntervalProfile mProfile;
	private Command cProfileChangeCommand;
	private Command cUpdateProfileInterface;
	
	public SetBetweenTimeCommand(IntervalProfile m, Command pcc, Command upi)
	{
		mProfile = m;
		cProfileChangeCommand = pcc;
		cUpdateProfileInterface = upi;
	}
	
	@Override
	public void onCommand() 
	{
		long sdelay = mProfile.getBetweenDelay();
		long hours = sdelay / 3600;
		sdelay = sdelay % 3600;
		long mins = sdelay / 60;
		sdelay = sdelay % 60;
		long secs = sdelay;
		
		TimeTunerJDialog vTuner = new TimeTunerJDialog("In-Between Delay");
		vTuner.setStartDelayText(hours, mins, secs);
		vTuner.setVisible(true);
		if (!vTuner.isAccepted()) return;
		
		String h = vTuner.getHoursInput();
		String m = vTuner.getMinutesInput();
		String s = vTuner.getSecondsInput();
		hours = Convert.toInt(h);
		mins = Convert.toInt(m);
		secs = Convert.toInt(s);
		
		long counter = secs + (60 * mins) + (3600 * hours);
		mProfile.setBetweenDelay(counter);
		
		cUpdateProfileInterface.onCommand();
		if (sdelay != counter) cProfileChangeCommand.onCommand();
	}
}
