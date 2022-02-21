package com.nullpointerworks.intervalometer.view;

import java.awt.Dialog;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.nullpointerworks.intervalometer.view.awt.AbsoluteLayout;
import com.nullpointerworks.intervalometer.view.swing.JTextFieldFilter;

public class TimeTunerJDialog extends JDialog 
{
	private static final long serialVersionUID = 913577687449225667L;

	private JTextField jtfHours;
	private JTextField jtfMins;
	private JTextField jtfSecs;
	
	
	public TimeTunerJDialog(String title)
	{
		super(null, Dialog.ModalityType.APPLICATION_MODAL);
		
		jtfHours = new JTextField();
		jtfHours.setLocation(10, 10);
		jtfHours.setSize(40, 20);
		jtfHours.setDocument( new JTextFieldFilter( JTextFieldFilter.NUMERIC ) );
		jtfHours.setHorizontalAlignment( JTextField.RIGHT );
		//jtfHours.setToolTipText( "The amount of hours of the exposure." );
		
		JLabel jlHours = new JLabel("h");
		jlHours.setLocation(55, 10);
		jlHours.setSize(30, 20);
		
		jtfMins = new JTextField();
		jtfMins.setLocation(75, 10);
		jtfMins.setSize(40, 20);
		jtfMins.setDocument( new JTextFieldFilter( JTextFieldFilter.NUMERIC ) );
		jtfMins.setHorizontalAlignment( JTextField.RIGHT );
		
		JLabel jlMinutes = new JLabel("'");
		jlMinutes.setLocation(120, 10);
		jlMinutes.setSize(40, 20);
		
		jtfSecs = new JTextField();
		jtfSecs.setLocation(140, 10);
		jtfSecs.setSize(40, 20);
		jtfSecs.setDocument( new JTextFieldFilter( JTextFieldFilter.NUMERIC ) );
		jtfSecs.setHorizontalAlignment( JTextField.RIGHT );
		
		JLabel jlSeconds = new JLabel("\"");
		jlSeconds.setLocation(185, 10);
		jlSeconds.setSize(40, 20);
		
		JPanel jpInterface = new JPanel();
		jpInterface.setLayout( new AbsoluteLayout() );
		jpInterface.setLocation(0, 0);
		jpInterface.setSize(320, 240);
		jpInterface.setPreferredSize( jpInterface.getSize() );
		jpInterface.add(jtfHours);
		jpInterface.add(jtfMins);
		jpInterface.add(jtfSecs);
		jpInterface.add(jlHours);
		jpInterface.add(jlMinutes);
		jpInterface.add(jlSeconds);
		
		setTitle(title);
		setResizable(false);
		add(jpInterface);
		pack();
		setLocationRelativeTo(null);
	}
	
	
	
	
	
	
}
