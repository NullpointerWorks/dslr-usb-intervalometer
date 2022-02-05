package com.nullpointerworks.intervalometer.view;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.nullpointerworks.intervalometer.view.awt.AbsoluteLayout;
import com.nullpointerworks.intervalometer.view.swing.StatusBarJPanel;

public class ApplicationView 
{
	private JFrame jfWindow;
	private StatusBarJPanel jpStatusBar;
	
	
	
	
	public ApplicationView(String title, int width, int height)
	{
		
		
		
		jpStatusBar = new StatusBarJPanel();
		jpStatusBar.setSize(width,20);
		jpStatusBar.setPreferredSize( jpStatusBar.getSize() );
		//jpStatusBar.addStatusBarElement(jlVersionText);
		
		JPanel jpInterface = new JPanel();
		jpInterface.setLocation(0, 0);
		jpInterface.setSize(width, height);
		jpInterface.setPreferredSize( jpInterface.getSize() );
		jpInterface.setLayout( new BorderLayout() );
		jpInterface.setBackground( Color.WHITE );
		jpInterface.add(jpStatusBar, BorderLayout.SOUTH);
		
		jfWindow = new JFrame();
		jfWindow.setTitle(title);
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
