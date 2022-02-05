package com.nullpointerworks.intervalometer.view.swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class StatusBarJPanel extends JPanel
{
	private static final long serialVersionUID = -1000049241956777801L;
	private Border border;
	
	public StatusBarJPanel()
	{
		setBorder( BorderFactory.createEmptyBorder());
		setLayout( new FlowLayout(FlowLayout.LEFT, 0, 0) );
		border = new SeparatorBorder(new Color(200,200,200));
	}
	
	public void setBarElementBorder(Border border)
	{
		if (border==null) return;
		this.border = border;
	}
	
	public void addStatusBarElement(Component comp) 
	{
		JPanel jpPanel = new JPanel();
		jpPanel.setSize(comp.getSize().width, this.getSize().height);
		jpPanel.setPreferredSize(jpPanel.getSize());
		jpPanel.setLayout( new BorderLayout() );
		jpPanel.setBorder( border );
		jpPanel.add(comp);
		add(jpPanel);
	}
}

