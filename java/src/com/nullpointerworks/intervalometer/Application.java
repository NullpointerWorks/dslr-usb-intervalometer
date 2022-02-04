package com.nullpointerworks.intervalometer;

import com.nullpointerworks.intervalometer.model.Mcp2221DeviceFactory;
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
		
		
		
		
		
		
		ApplicationView vWindow = new ApplicationView();
		
		vWindow.setVisible(true);
	}
	
	
}
