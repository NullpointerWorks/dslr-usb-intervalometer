package com.nullpointerworks.intervalometer.view.swing;

import javax.swing.JMenu;

public class RolloverJMenu extends JMenu 
{
	public RolloverJMenu()
	{
		setRolloverEnabled(false);
	}
	
	public RolloverJMenu(String s)
	{
		super(s);
		setRolloverEnabled(false);
	}
}
