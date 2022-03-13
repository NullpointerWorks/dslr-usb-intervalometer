package com.nullpointerworks.intervalometer.control;

import com.nullpointerworks.intervalometer.control.interfaces.Command;
import com.nullpointerworks.intervalometer.model.nativeinterface.GPIO;
import com.nullpointerworks.intervalometer.model.nativeinterface.Mcp2221Device;
import com.nullpointerworks.intervalometer.model.profile.IntervalProfile;
import com.nullpointerworks.intervalometer.view.ProfileJPanel;

public class TakeExposuresCommand implements Command, Runnable
{
	private ProfileJPanel vProfile;
	private IntervalProfile mProfile;
	private Mcp2221Device mDevice;
	private boolean running;
	
	public TakeExposuresCommand(ProfileJPanel p, IntervalProfile i, Mcp2221Device d)
	{
		vProfile = p;
		mProfile = i;
		mDevice = d;
		running = false;
	}
	
	@Override
	public void onCommand() 
	{
		Thread t = new Thread(this);
		t.start();
	}
	
	public void stop()
	{
		running = false;
	}
	
	@Override
	public void run() 
	{
		long start_delay = mProfile.getStartDelay();
		long exposure_time = mProfile.getExposureTime();
		long between_delay = mProfile.getBetweenDelay();
		long exposures_cnt = mProfile.getExposures();
		long exposures_taken = 0;
		running = true;
		
		System.out.println("starting");
		sleepSeconds(start_delay);
		while(running)
		{
			System.out.println("shutter open");
			mDevice.setGPIOValue(GPIO.GP0, true);
			sleepSeconds(exposure_time);
			
			System.out.println("shutter closed");
			mDevice.setGPIOValue(GPIO.GP0, false);
			
			exposures_taken++;
			vProfile.setExposuresTakenText( ""+exposures_taken );

			System.out.println("delay");
			sleepSeconds(between_delay);
			
			if (exposures_taken >= exposures_cnt) break;
		}
		mDevice.closeConnection();
	}
	
	private void sleepSeconds(long milli)
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
