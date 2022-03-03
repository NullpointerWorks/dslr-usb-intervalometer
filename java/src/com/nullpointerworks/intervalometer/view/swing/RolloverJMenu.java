package com.nullpointerworks.intervalometer.view.swing;

import java.awt.Insets;

import javax.swing.JMenu;

public class RolloverJMenu extends JMenu 
{
	private static final long serialVersionUID = -563965477578666188L;

	public RolloverJMenu(String s)
	{
		super(s);
		setRolloverEnabled(false);
		setMargin(new Insets(-1,0,0,0));// makes menu items not as tall as its default
	}
}
