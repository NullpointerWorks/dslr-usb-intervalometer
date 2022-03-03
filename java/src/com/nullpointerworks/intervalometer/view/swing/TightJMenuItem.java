package com.nullpointerworks.intervalometer.view.swing;

import java.awt.Insets;

import javax.swing.JMenuItem;

public class TightJMenuItem extends JMenuItem 
{
	private static final long serialVersionUID = 9109292451975121318L;

	public TightJMenuItem(String s) 
	{
		super(s);
		setMargin(new Insets(-1,0,0,0));// makes menu items not as tall as its default
	}
}
