package com.nullpointerworks.intervalometer.view;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.nullpointerworks.intervalometer.view.awt.AbsoluteLayout;

public class ApplicationView 
{
	public JFrame jfWindow;
	
	
	
	
	public ApplicationView()
	{
		
		
		
		
		
		
		JPanel jpInterface = new JPanel();
		jpInterface.setLocation(0, 0);
		jpInterface.setSize(640, 550);
		jpInterface.setPreferredSize( jpInterface.getSize() );
		jpInterface.setLayout( new AbsoluteLayout() );
		jpInterface.setBackground( Color.WHITE );
		
		jfWindow = new JFrame();
		jfWindow.setTitle("DSLR Intervalometer");
		jfWindow.setResizable(false);
		jfWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jfWindow.setLayout( new AbsoluteLayout() );
		jfWindow.add(jpInterface);
		jfWindow.pack();
		jfWindow.setLocationRelativeTo(null);
		
	}
	
	public void setVisible(boolean b)
	{
		jfWindow.setVisible(b);
	}
	
	
}
