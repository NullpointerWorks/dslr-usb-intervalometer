package com.nullpointerworks.intervalometer.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

import com.nullpointerworks.intervalometer.control.interfaces.DocumentCommand;
import com.nullpointerworks.intervalometer.view.awt.AbsoluteLayout;
import com.nullpointerworks.intervalometer.view.swing.JTextFieldFilter;

public class ProfileJPanel extends JPanel
{
	private static final long serialVersionUID = -7670816939485627712L;
	
	private JButton jbSetStartDelay;
	private JButton jbSetExposure;
	private JButton jbSetDelay;
	
	private JTextField jtfNumber;
	private JTextField jtfProName;
	private JTextArea jtaNotes;
	
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
		
		JLabel jlProName = new JLabel("Profile Name:");
		jlProName.setLocation(12, 230);
		jlProName.setSize(80, 20);
		
		jtfProName = new JTextField();
		jtfProName.setLocation(90, 230);
		jtfProName.setSize(232, 20);
		
		JLabel lbNotes = new JLabel("Notes:");
		lbNotes.setLocation(12, 260);
		lbNotes.setSize(100, 20);
		
		jtaNotes = new JTextArea();
		jtaNotes.setLineWrap(true);
		jtaNotes.setWrapStyleWord(true);
		jtaNotes.setBackground( new Color(250,250,250) );
		jtaNotes.setFont( new Font("Tahoma", Font.PLAIN, 11) );
		JScrollPane jspNotes = new JScrollPane(jtaNotes);
		jspNotes.setLocation(7, 280);
		jspNotes.setSize(315, 140);
		jspNotes.setPreferredSize(jtaNotes.getSize());
		jspNotes.setBorder( BorderFactory.createLoweredBevelBorder() );
		jspNotes.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		
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
		add(jlProName);
		add(jtfProName);
		add(lbNotes);
		add(jspNotes);
	}
	
	public String getProfileName() {return jtfProName.getText();}
	public String getProfileNotes() {return jtaNotes.getText();}
	
	public void setProfileName(String profileName) {jtfProName.setText(profileName);}
	
	public void setNameChangeCommand(DocumentCommand dc) {jtfProName.getDocument().addDocumentListener(dc);}
	public void setNotesChangeCommand(DocumentCommand dc) {jtaNotes.getDocument().addDocumentListener(dc);}
	
	
	
	
	
}
