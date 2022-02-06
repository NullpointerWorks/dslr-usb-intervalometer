package com.nullpointerworks.intervalometer.view;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.nullpointerworks.intervalometer.view.awt.AbsoluteLayout;
import com.nullpointerworks.intervalometer.view.swing.JTextFieldFilter;


/*

intervalometer needs a few thins;
- start-up delay
- image exposure time
- delay between images
- number of images to take
- start/stop button

useful things to have:
- audible alarm when done (can be disabled)
  or notify the user by flashing the taskbar to draw attention
- focusing ability for non-astrophotography purposes



*/

public class ProfileJPanel extends JPanel
{
	private static final long serialVersionUID = -7670816939485627712L;
	
	
	private JButton jbSetStartDelay;
	private JButton jbSetExposure;
	private JButton jbSetDelay;
	
	
	private JTextField jtfNumber;
	
	public ProfileJPanel()
	{
		JLabel lbStartDelay = new JLabel("Start-up Delay:");
		lbStartDelay.setLocation(20, 20);
		lbStartDelay.setSize(100, 20);
		JLabel lbExposureTime = new JLabel("Exposure Time:");
		lbExposureTime.setLocation(20, 45);
		lbExposureTime.setSize(100, 20);
		JLabel lbInBetweenDelay = new JLabel("In-Between Delay:");
		lbInBetweenDelay.setLocation(20, 70);
		lbInBetweenDelay.setSize(100, 20);
		JLabel lbNumberExposures = new JLabel("Desired Exposures:");
		lbNumberExposures.setLocation(20, 95);
		lbNumberExposures.setSize(100, 20);
		
		jbSetStartDelay = new JButton("Set");
		jbSetStartDelay.setLocation(250, 20);
		jbSetStartDelay.setSize(50, 20);
		jbSetExposure = new JButton("Set");
		jbSetExposure.setLocation(250, 45);
		jbSetExposure.setSize(50, 20);
		jbSetDelay = new JButton("Set");
		jbSetDelay.setLocation(250, 70);
		jbSetDelay.setSize(50, 20);
		
		JTextField jtfNumber = new JTextField();
		jtfNumber.setDocument( new JTextFieldFilter( JTextFieldFilter.NUMERIC ) );
		
		
		
		
		
		
		JButton jbStartStop = new JButton("Start");
		jbStartStop.setLocation(20, 20);
		jbStartStop.setSize(70, 20);
		
		JLabel lbExposuresTaken = new JLabel("Exposures Taken:");
		lbExposuresTaken.setLocation(20, 45);
		lbExposuresTaken.setSize(100, 20);
		
		
		
		
		JPanel jpIntervalometer = new JPanel();
		jpIntervalometer.setLayout( new AbsoluteLayout() );
		jpIntervalometer.setBorder( BorderFactory.createTitledBorder("Intervalometer") );
		jpIntervalometer.setLocation(5, 5);
		jpIntervalometer.setSize(320, 130);
		jpIntervalometer.setPreferredSize(jpIntervalometer.getSize());
		jpIntervalometer.setBackground( Color.WHITE );
		
		jpIntervalometer.add(lbStartDelay);
		jpIntervalometer.add(lbExposureTime);
		jpIntervalometer.add(lbInBetweenDelay);
		jpIntervalometer.add(lbNumberExposures);
		jpIntervalometer.add(jbSetStartDelay);
		jpIntervalometer.add(jbSetExposure);
		jpIntervalometer.add(jbSetDelay);
		
		JPanel jpSession = new JPanel();
		jpSession.setLayout( new AbsoluteLayout() );
		jpSession.setBorder( BorderFactory.createTitledBorder("Session") );
		jpSession.setLocation(5, 140);
		jpSession.setSize(320, 80);
		jpSession.setPreferredSize(jpSession.getSize());
		jpSession.setBackground( Color.WHITE );
		jpSession.add(jbStartStop);
		jpSession.add(lbExposuresTaken);
		
		setSize(640, 480);
		setPreferredSize( getSize() );
		setBackground( Color.WHITE );
		setLayout( new AbsoluteLayout() );
		add(jpIntervalometer);
		add(jpSession);
	}
	
	
	
}
