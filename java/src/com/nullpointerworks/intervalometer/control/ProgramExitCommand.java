package com.nullpointerworks.intervalometer.control;

import com.nullpointerworks.intervalometer.control.interfaces.ActionCommand;

public class ProgramExitCommand implements ActionCommand 
{
	
	public ProgramExitCommand()
	{
		
		
	}
	
	@Override
	public void onCommand() 
	{
		
		
		System.exit(0);
	}
}
