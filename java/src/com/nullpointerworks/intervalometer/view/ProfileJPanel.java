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

import com.nullpointerworks.intervalometer.control.interfaces.ActionCommand;
import com.nullpointerworks.intervalometer.control.interfaces.DocumentCommand;
import com.nullpointerworks.intervalometer.view.awt.AbsoluteLayout;
import com.nullpointerworks.intervalometer.view.swing.JTextFieldFilter;

public class ProfileJPanel extends JPanel
{
	private static final long serialVersionUID = -7670816939485627712L;
	
	private JButton jbSetStartDelay;
	private JButton jbSetExposure;
	private JButton jbSetDelay;
	private JButton jbStartStop;

	private JTextField jtfStartDelay;
	private JTextField jtfExposureTime;
	private JTextField jtfBetweenDelay;
	private JTextField jtfExposures;
	private JTextField jtfNumber;
	private JTextArea jtaNotes;
	
	public ProfileJPanel()
	{
		JLabel lbStartDelay = new JLabel("Start-up Delay:");
		lbStartDelay.setLocation(20, 20);
		lbStartDelay.setSize(100, 20);
		jtfStartDelay = new JTextField();
		jtfStartDelay.setLocation(130, 20);
		jtfStartDelay.setSize(100, 20);
		jtfStartDelay.setEditable(false);
		jtfStartDelay.setHorizontalAlignment(JTextField.RIGHT);
		
		JLabel lbExposureTime = new JLabel("Exposure Time:");
		lbExposureTime.setLocation(20, 45);
		lbExposureTime.setSize(100, 20);
		jtfExposureTime = new JTextField();
		jtfExposureTime.setLocation(130, 45);
		jtfExposureTime.setSize(100, 20);
		jtfExposureTime.setEditable(false);
		jtfExposureTime.setHorizontalAlignment(JTextField.RIGHT);
		
		JLabel lbInBetweenDelay = new JLabel("In-Between Delay:");
		lbInBetweenDelay.setLocation(20, 70);
		lbInBetweenDelay.setSize(100, 20);
		jtfBetweenDelay = new JTextField();
		jtfBetweenDelay.setLocation(130, 70);
		jtfBetweenDelay.setSize(100, 20);
		jtfBetweenDelay.setEditable(false);
		jtfBetweenDelay.setHorizontalAlignment(JTextField.RIGHT);
		
		JLabel lbNumberExposures = new JLabel("Desired Exposures:");
		lbNumberExposures.setLocation(20, 95);
		lbNumberExposures.setSize(100, 20);
		jtfExposures = new JTextField();
		jtfExposures.setLocation(130, 95);
		jtfExposures.setSize(100, 20);
		jtfExposures.setHorizontalAlignment(JTextField.RIGHT);
		
		jbSetStartDelay = new JButton("Set");
		jbSetStartDelay.setLocation(250, 20);
		jbSetStartDelay.setSize(50, 20);
		jbSetExposure = new JButton("Set");
		jbSetExposure.setLocation(250, 45);
		jbSetExposure.setSize(50, 20);
		jbSetDelay = new JButton("Set");
		jbSetDelay.setLocation(250, 70);
		jbSetDelay.setSize(50, 20);
		
		jbStartStop = new JButton();
		jbStartStop.setLocation(20, 20);
		jbStartStop.setSize(70, 20);
		setStartButtonState(false);
		
		JLabel lbExposuresTaken = new JLabel("Exposures Taken:");
		lbExposuresTaken.setLocation(20, 45);
		lbExposuresTaken.setSize(100, 20);
		jtfNumber = new JTextField();
		jtfNumber.setDocument( new JTextFieldFilter( JTextFieldFilter.NUMERIC ) );
		jtfNumber.setHorizontalAlignment(JTextField.RIGHT);
		jtfNumber.setLocation(130, 45);
		jtfNumber.setSize(100, 20);
		
		JLabel lbNotes = new JLabel("Notes:");
		lbNotes.setLocation(12, 220);
		lbNotes.setSize(100, 20);
		
		jtaNotes = new JTextArea();
		jtaNotes.setLineWrap(true);
		jtaNotes.setWrapStyleWord(true);
		jtaNotes.setBackground( new Color(250,250,250) );
		jtaNotes.setFont( new Font("Tahoma", Font.PLAIN, 11) );
		JScrollPane jspNotes = new JScrollPane(jtaNotes);
		jspNotes.setLocation(7, 240);
		jspNotes.setSize(315, 180);
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
		jpIntervalometer.add(jtfStartDelay);
		jpIntervalometer.add(jtfExposureTime);
		jpIntervalometer.add(jtfBetweenDelay);
		jpIntervalometer.add(jtfExposures);
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
		jpSession.add(jtfNumber);
		
		setSize(640, 480);
		setPreferredSize( getSize() );
		setBackground( Color.WHITE );
		setLayout( new AbsoluteLayout() );
		add(jpIntervalometer);
		add(jpSession);
		add(lbNotes);
		add(jspNotes);
	}
	
	public void setStartButtonState(boolean b)
	{
		if (!b)
		{
			jbStartStop.setText("Start");
		}
		else
		{
			jbStartStop.setText("Stop");
		}
	}
	
	public String getProfileNotes() {return jtaNotes.getText();}

	public void setStartDelayText(String t) {jtfStartDelay.setText(t);}
	public void setExposureTimeText(String t) {jtfExposureTime.setText(t);}
	public void setBetweenDelayText(String t) {jtfBetweenDelay.setText(t);}
	public void setExposuresText(String t) {jtfExposures.setText(t);}
	public void setExposuresTakenText(String t) {jtfNumber.setText(t);}
	
	public void setProfileNotes(String profileNote) {jtaNotes.setText(profileNote);}
	
	public void setNotesChangeCommand(DocumentCommand dc) {jtaNotes.getDocument().addDocumentListener(dc);}
	public void setStartUpDelayCommand(ActionCommand ac) {jbSetStartDelay.addActionListener(ac);}
	public void setExposureTimeCommand(ActionCommand ac) {jbSetExposure.addActionListener(ac);}
	public void setBetweenDelayCommand(ActionCommand ac) {jbSetDelay.addActionListener(ac);}
	public void setStartSessionCommand(ActionCommand ac) {jbStartStop.addActionListener(ac);}
	
}
