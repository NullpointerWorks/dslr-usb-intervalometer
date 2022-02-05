package com.nullpointerworks.intervalometer;

import java.awt.Color;

import javax.swing.UIManager;

import com.nullpointerworks.intervalometer.model.nativeinterface.GPIO;
import com.nullpointerworks.intervalometer.model.nativeinterface.IMcp2221Device;
import com.nullpointerworks.intervalometer.model.nativeinterface.Mcp2221DeviceFactory;
import com.nullpointerworks.intervalometer.view.ApplicationView;
import com.nullpointerworks.intervalometer.view.swing.UILookAndFeel;

public class Application 
{
	public static final String VERSION = "v0.1.0";

	public static void main(String[] args) 
	{
		new Application();
	}
	
	Application()
	{
		UILookAndFeel.setLookAndFeel( UILookAndFeel.WINDOWS );
		
		
		Mcp2221DeviceFactory mFactory = new Mcp2221DeviceFactory();
		
		
		/*
		IMcp2221Device device = mFactory.getDeviceBySerialNumber("0000449396");
		
		
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
		
		
		ApplicationView vWindow = new ApplicationView();
		vWindow.setVisible(true);
	}
	
	
	
	private void sleep(int i) 
	{
		try 
		{
			Thread.sleep(i);
		} 
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
	}
}
