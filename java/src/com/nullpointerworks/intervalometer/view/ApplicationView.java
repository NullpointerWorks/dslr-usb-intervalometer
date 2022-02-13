package com.nullpointerworks.intervalometer.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

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
import com.nullpointerworks.intervalometer.view.swing.TightJMenuItem;

public class ApplicationView 
{
	private JFrame jfWindow;
	private StatusBarJPanel jpStatusBar;
	
	private JTabbedPane tpTabs;
	private JLabel jlConnectStatus;
	private JLabel jlSerialNumber;
	
	private JMenuItem jmiConnect;
	private JMenu jmConnectRecent;
	private JMenuItem jmiClearDevHistory;
	private JMenuItem jmiDisconnect;
	private JMenuItem jmiExit;
	
	private JMenuItem jmiNewProfile;
	private JMenuItem jmiLoadProfile;
	private JMenu jmLoadRecent;
	private JMenuItem jmiClearProHistory;
	private JMenuItem jmiSaveProfile;
	private JMenuItem jmiSaveAsProfile;
	
	public ApplicationView(String title)
	{
		
		// menu bar
		JMenuBar jmbMainMenu = new JMenuBar();
		
		JMenu jmProgram = new JMenu("Program");
		jmiConnect = new TightJMenuItem("Connect To Device");
		jmConnectRecent = new RolloverJMenu("Recent Devices");
		jmiClearDevHistory = new TightJMenuItem("Clear History");
		jmiDisconnect = new TightJMenuItem("Disconnect Device");
		jmiExit = new TightJMenuItem("Exit");
		
		JMenu jmProfile = new JMenu("Profile");
		jmiNewProfile = new TightJMenuItem("New");
		jmiLoadProfile = new TightJMenuItem("Load");
		jmLoadRecent = new RolloverJMenu("Load Recent");
		jmiClearProHistory = new TightJMenuItem("Clear History");
		jmiSaveProfile = new TightJMenuItem("Save");
		jmiSaveAsProfile = new TightJMenuItem("Save As...");
		
		JMenu jmAbout = new JMenu("About");
		
		
		jmConnectRecent.addSeparator();
		jmConnectRecent.add(jmiClearDevHistory);
		
		jmLoadRecent.addSeparator();
		jmLoadRecent.add(jmiClearProHistory);
		
		jmProgram.add(jmiConnect);
		jmProgram.add(jmConnectRecent);
		jmProgram.addSeparator();
		jmProgram.add(jmiDisconnect);
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
		
		jmiDisconnect.setEnabled(false);
		
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
	
	public void setConnectToCommand(ActionCommand c) {jmiConnect.addActionListener(c);}
	public void setClearDevHistoryCommand(ActionCommand c) {jmiClearDevHistory.addActionListener(c);}
	public void setDisconnectCommand(ActionCommand c) {jmiDisconnect.addActionListener(c);}
	public void setExitCommand(ActionCommand c) {jmiExit.addActionListener(c);}
	
	public void setNewProfileCommand(ActionCommand c) {jmiNewProfile.addActionListener(c);}
	public void setLoadProfileCommand(ActionCommand c) {jmiLoadProfile.addActionListener(c);}
	public void setClearProHistoryCommand(ActionCommand c) {jmiClearProHistory.addActionListener(c);}
	public void setSaveProfileCommand(ActionCommand c) {jmiSaveProfile.addActionListener(c);}
	public void setSaveAsProfileCommand(ActionCommand c) {jmiSaveAsProfile.addActionListener(c);}
	
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
		jmiConnect.setEnabled(!b);
		jmiDisconnect.setEnabled(b);
		
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
	
	public void setRecentDevices(List<String> list, List<ActionCommand> commands)
	{
		jmConnectRecent.removeAll();
		
		int i=0;
		int l=list.size();
		for (; i<l; i++)
		{
			String sn 			= list.get(i);
			ActionCommand ac 	= commands.get(i);
			
			JMenuItem jmiRecDev = new TightJMenuItem(sn);
			jmiRecDev.addActionListener(ac);
			jmConnectRecent.add(jmiRecDev);
		}
		
		jmConnectRecent.addSeparator();
		jmConnectRecent.add(jmiClearDevHistory);
	}
}
