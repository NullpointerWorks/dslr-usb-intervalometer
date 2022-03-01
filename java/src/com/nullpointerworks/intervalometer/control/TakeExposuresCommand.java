package com.nullpointerworks.intervalometer.control;

import com.nullpointerworks.intervalometer.control.interfaces.RunnableCommand;
import com.nullpointerworks.intervalometer.model.nativeinterface.Mcp2221Device;

public class TakeExposuresCommand implements RunnableCommand 
{
	private Mcp2221Device mDevice;
	
	public TakeExposuresCommand(Mcp2221Device d)
	{
		mDevice = d;
	}
	
	@Override
	public void onCommand() 
	{
		
		
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
