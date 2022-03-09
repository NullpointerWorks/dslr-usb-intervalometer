package com.nullpointerworks.intervalometer.control;

import com.nullpointerworks.intervalometer.control.interfaces.RunnableCommand;
import com.nullpointerworks.intervalometer.model.nativeinterface.GPIO;
import com.nullpointerworks.intervalometer.model.nativeinterface.Mcp2221Device;
import com.nullpointerworks.intervalometer.model.profile.IntervalProfile;
import com.nullpointerworks.intervalometer.view.ProfileJPanel;

public class TakeExposuresCommand implements RunnableCommand 
{
	private ProfileJPanel vProfile;
	private IntervalProfile mProfile;
	private Mcp2221Device mDevice;
	
	public TakeExposuresCommand(ProfileJPanel p, IntervalProfile i, Mcp2221Device d)
	{
		vProfile = p;
		mProfile = i;
		mDevice = d;
	}
	
	@Override
	public void onCommand() 
	{
		int start_delay = mProfile.getStartDelay();
		int exposure_time = mProfile.getExposureTime();
		int between_delay = mProfile.getBetweenDelay();
		int exposures_cnt = mProfile.getExposures();
		int exposures_taken = 0;
		
		sleepSeconds(start_delay);
		while(exposures_taken < exposures_cnt)
		{
			mDevice.setGPIOValue(GPIO.GP0, true);
			sleepSeconds(exposure_time);
			mDevice.setGPIOValue(GPIO.GP0, false);

			exposures_taken++;
			vProfile.setExposuresText( ""+exposures_taken );
			
			sleepSeconds(between_delay);
		}
		mDevice.closeConnection();
	}
	
	private void sleepSeconds(int milli)
	{
		try 
		{
			Thread.sleep(milli * 1000);
		} 
		catch (InterruptedException e) 
		{
			return;
		}
	}
	
	
}
