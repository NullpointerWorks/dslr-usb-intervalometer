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
		
		
		
		
		
		
		
		JButton jbSetStartDelay = new JButton("Set");
		jbSetStartDelay.setLocation(150, 20);
		jbSetStartDelay.setSize(50, 20);
		
		JButton jbSetExposure = new JButton();
		JButton jbSetDelay = new JButton();
		JLabel jlPictureAmount = new JLabel();
		JButton jbStartStop = new JButton();
		
		
		
		JTextField jtfNumber = new JTextField();
		jtfNumber.setDocument( new JTextFieldFilter( JTextFieldFilter.NUMERIC ) );
		
		
		
		
		
		
		
		JPanel jpIntervalometer = new JPanel();
		jpIntervalometer.setLayout( new AbsoluteLayout() );
		jpIntervalometer.setBorder( BorderFactory.createTitledBorder("Intervalometer") );
		jpIntervalometer.setLocation(5, 5);
		jpIntervalometer.setSize(250, 150);
		jpIntervalometer.setPreferredSize(jpIntervalometer.getSize());
		jpIntervalometer.setBackground( Color.WHITE );
		
		jpIntervalometer.add(lbStartDelay);
		jpIntervalometer.add(lbExposureTime);
		jpIntervalometer.add(lbInBetweenDelay);
		
		
		
		jpIntervalometer.add(jbSetStartDelay);
		
		
		
		
		
		
		
		
		setSize(640, 480);
		setPreferredSize( getSize() );
		setBackground( Color.WHITE );
		setLayout( new AbsoluteLayout() );
		add(jpIntervalometer);
		
	}
	
	
}
