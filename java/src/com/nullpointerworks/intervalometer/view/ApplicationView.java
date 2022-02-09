package com.nullpointerworks.intervalometer.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Insets;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import com.nullpointerworks.intervalometer.control.interfaces.ActionCommand;
import com.nullpointerworks.intervalometer.view.awt.AbsoluteLayout;
import com.nullpointerworks.intervalometer.view.swing.RolloverJMenu;
import com.nullpointerworks.intervalometer.view.swing.StatusBarJPanel;

public class ApplicationView 
{
	private JFrame jfWindow;
	private StatusBarJPanel jpStatusBar;
	
	private JTabbedPane tpTabs;
	private JLabel jlConnectStatus;
	private JLabel jlSerialNumber;

	private final Insets menuInset = new Insets(-1,0,0,0); // makes menu items not as tall as its default
	private JMenuItem jmiConnect;
	private JMenuItem jmiExit;
	private JMenuItem jmiNewProfile;
	private JMenuItem jmiLoadProfile;
	private JMenuItem jmiSaveProfile;
	private JMenuItem jmiSaveAsProfile;
	
	public ApplicationView(String title)
	{
		
		// menu bar
		JMenuBar jmbMainMenu = new JMenuBar();
		
		JMenu jmConnectRecent = new RolloverJMenu("Device History");
		JMenuItem jmiClearHistory = new JMenuItem("Clear History");
		
		JMenu jmProgram = new JMenu("Program");
		jmiConnect = new JMenuItem("Connect To Device");
		jmiExit = new JMenuItem("Exit");
		
		JMenu jmProfile = new JMenu("Profile");
		jmiNewProfile = new JMenuItem("New");
		jmiLoadProfile = new JMenuItem("Load");
		JMenu jmLoadRecent = new JMenu("Load Recent");
		jmiSaveProfile = new JMenuItem("Save");
		jmiSaveAsProfile = new JMenuItem("Save As...");
		
		JMenu jmAbout = new JMenu("About");
		
		
		jmConnectRecent.addSeparator();
		jmConnectRecent.add(jmiClearHistory);
		
		jmiConnect.setMargin(menuInset);
		jmConnectRecent.setMargin(menuInset);
		jmiClearHistory.setMargin(menuInset);
		jmiExit.setMargin(menuInset);
		jmiNewProfile.setMargin(menuInset);
		jmiLoadProfile.setMargin(menuInset);
		jmLoadRecent.setMargin(menuInset);
		jmiSaveProfile.setMargin(menuInset);
		jmiSaveAsProfile.setMargin(menuInset);
		
		jmProgram.add(jmiConnect);
		jmProgram.add(jmConnectRecent);
		jmProgram.addSeparator();
		jmProgram.add(jmiExit);
		
		jmProfile.add(jmiNewProfile);
		jmProfile.addSeparator();
		jmProfile.add(jmiLoadProfile);
		jmProfile.add(jmLoadRecent);
		jmProfile.addSeparator();
		jmProfile.add(jmiSaveProfile);
		jmProfile.add(jmiSaveAsProfile);
		
		jmbMainMenu.add(jmProgram);
		jmbMainMenu.add(jmProfile);
		jmbMainMenu.add(jmAbout);
		
		// tab interface
		tpTabs = new JTabbedPane();
		
		// status bar
		jlConnectStatus = new JLabel();
		jlConnectStatus.setSize( 100, 19 );
		jlConnectStatus.setText( "Not Connected" );
		jlConnectStatus.setForeground(Color.RED);
		
		jlSerialNumber = new JLabel();
		jlSerialNumber.setSize( 140, 19 );
		jlSerialNumber.setText( "S/N: " );
		
		jpStatusBar = new StatusBarJPanel();
		jpStatusBar.setSize(640, 20);
		jpStatusBar.setPreferredSize( jpStatusBar.getSize() );
		jpStatusBar.addStatusBarElement(jlConnectStatus);
		jpStatusBar.addStatusBarElement(jlSerialNumber);
		
		// interface
		JPanel jpInterface = new JPanel();
		jpInterface.setLocation(0, 0);
		jpInterface.setSize(340, 480);
		jpInterface.setPreferredSize( jpInterface.getSize() );
		jpInterface.setLayout( new BorderLayout() );
		jpInterface.add(tpTabs, BorderLayout.CENTER);
		jpInterface.add(jpStatusBar, BorderLayout.SOUTH);
		
		jfWindow = new JFrame();
		jfWindow.setTitle(title);
		jfWindow.setResizable(false);
		jfWindow.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		jfWindow.setLayout( new AbsoluteLayout() );
		jfWindow.setJMenuBar(jmbMainMenu);
		jfWindow.addWindowListener( new WindowAdapter() 
		{
			public void windowClosing(WindowEvent e)
			{
				jmiExit.doClick();
			}
		});
		jfWindow.add(jpInterface);
		jfWindow.pack();
		jfWindow.setLocationRelativeTo(null);
	}

	public void setConnectToCommand(ActionCommand aConnectTo) {jmiConnect.addActionListener(aConnectTo);}
	public void setExitCommand(ActionCommand aConnectTo) {jmiExit.addActionListener(aConnectTo);}
	
	public void setVisible(boolean b)
	{
		jfWindow.setVisible(b);
	}
	
	public void setDisplayTab(String title, ProfileJPanel comp) 
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
	
	public void setSerialNumber(String sn)
	{
		if (sn == null) sn = "";
		jlSerialNumber.setText("S/N: "+sn);
	}
}
