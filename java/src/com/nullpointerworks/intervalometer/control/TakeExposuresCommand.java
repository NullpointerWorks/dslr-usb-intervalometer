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

		/*
		Mcp2221Device device = mFactory.getDeviceBySerialNumber("0000449396");
		
		device.setGPIOValue(GPIO.GP1, true);
		sleep(1000);
		device.setGPIOValue(GPIO.GP1, false);
		sleep(100);
		
		device.setGPIOValue(GPIO.GP0, true);
		sleep(1000);
		device.setGPIOValue(GPIO.GP0, false);
		sleep(100);
		device.closeConnection();
		
		//*/
		
		while(true)
		{
			try 
			{
				Thread.sleep(500);
			} 
			catch (InterruptedException e) 
			{
				return;
			}
			
			System.out.println("cycle");
		}
		
		
		
	}
	
	
}
