package com.nullpointerworks.intervalometer;

import com.nullpointerworks.intervalometer.view.ApplicationView;

public class Application 
{
	public static final String VERSION = "v0.1.0";

	public static void main(String[] args) 
	{
		new Application();
	}
	
	Application()
	{
		
		ApplicationView vWindow = new ApplicationView();
		
		
		
		vWindow.setVisible(true);
	}
	
	
}