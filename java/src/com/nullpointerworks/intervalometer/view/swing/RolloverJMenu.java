package com.nullpointerworks.intervalometer.view.swing;

import java.awt.Insets;

import javax.swing.JMenu;

public class RolloverJMenu extends JMenu 
{
	public RolloverJMenu(String s)
	{
		super(s);
		setRolloverEnabled(false);
		setMargin(new Insets(-1,0,0,0));// makes menu items not as tall as its default
	}
}
