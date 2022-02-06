package com.nullpointerworks.intervalometer.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import com.nullpointerworks.intervalometer.view.awt.AbsoluteLayout;
import com.nullpointerworks.intervalometer.view.swing.StatusBarJPanel;

public class ApplicationView 
{
	private JFrame jfWindow;
	private StatusBarJPanel jpStatusBar;
	
	private JTabbedPane tpTabs;
	private JLabel jlConnectStatus;
	private JLabel jlSerialNumber;
	
	public ApplicationView(String title, int width, int height)
	{
		tpTabs = new JTabbedPane();
		
		jlConnectStatus = new JLabel();
		jlConnectStatus.setSize( 100, 19 );
		jlConnectStatus.setText( "Not Connected" );
		jlConnectStatus.setForeground(Color.RED);

		jlSerialNumber = new JLabel();
		jlSerialNumber.setSize( 140, 19 );
		jlSerialNumber.setText( "S/N: " );
		
		
		
		jpStatusBar = new StatusBarJPanel();
		jpStatusBar.setSize(width,20);
		jpStatusBar.setPreferredSize( jpStatusBar.getSize() );
		jpStatusBar.addStatusBarElement(jlConnectStatus);
		jpStatusBar.addStatusBarElement(jlSerialNumber);
		
		JPanel jpInterface = new JPanel();
		jpInterface.setLocation(0, 0);
		jpInterface.setSize(width, height);
		jpInterface.setPreferredSize( jpInterface.getSize() );
		jpInterface.setLayout( new BorderLayout() );
		jpInterface.setBackground( Color.WHITE );
		jpInterface.add(tpTabs, BorderLayout.CENTER);
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
	
	public void setDisplayTab(String title, Component comp) 
	{
		tpTabs.removeAll();
		tpTabs.addTab(title, comp);
	}
	
	public void setConnected(boolean b)
	{
		if (b)
		{
			jlConnectStatus.setText( "Connected" );
			jlConnectStatus.setForeground(Color.GREEN);
			return;
		}
		
		jlConnectStatus.setText( "Not Connected" );
		jlConnectStatus.setForeground(Color.RED);
	}
}
