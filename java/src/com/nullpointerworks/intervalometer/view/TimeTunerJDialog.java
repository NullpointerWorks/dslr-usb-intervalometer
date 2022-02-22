package com.nullpointerworks.intervalometer.view;

import java.awt.Dialog;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.nullpointerworks.intervalometer.control.interfaces.ActionCommand;
import com.nullpointerworks.intervalometer.view.awt.AbsoluteLayout;
import com.nullpointerworks.intervalometer.view.swing.JTextFieldFilter;

public class TimeTunerJDialog extends JDialog 
{
	private static final long serialVersionUID = 913577687449225667L;

	private JTextField jtfHours;
	private JTextField jtfMins;
	private JTextField jtfSecs;

	private JButton lbCancel;
	private JButton lbAccept;
	
	public TimeTunerJDialog(String title)
	{
		super(null, Dialog.ModalityType.APPLICATION_MODAL);
		
		jtfHours = new JTextField();
		jtfHours.setLocation(25, 10);
		jtfHours.setSize(40, 20);
		jtfHours.setDocument( new JTextFieldFilter( JTextFieldFilter.NUMERIC ) );
		jtfHours.setHorizontalAlignment( JTextField.RIGHT );
		//jtfHours.setToolTipText( "The amount of hours of the exposure." );
		
		JLabel jlHours = new JLabel("h");
		jlHours.setLocation(70, 10);
		jlHours.setSize(30, 20);
		
		jtfMins = new JTextField();
		jtfMins.setLocation(90, 10);
		jtfMins.setSize(40, 20);
		jtfMins.setDocument( new JTextFieldFilter( JTextFieldFilter.NUMERIC ) );
		jtfMins.setHorizontalAlignment( JTextField.RIGHT );
		
		JLabel jlMinutes = new JLabel("'");
		jlMinutes.setLocation(135, 10);
		jlMinutes.setSize(40, 20);
		
		jtfSecs = new JTextField();
		jtfSecs.setLocation(150, 10);
		jtfSecs.setSize(40, 20);
		jtfSecs.setDocument( new JTextFieldFilter( JTextFieldFilter.NUMERIC ) );
		jtfSecs.setHorizontalAlignment( JTextField.RIGHT );
		
		JLabel jlSeconds = new JLabel("\"");
		jlSeconds.setLocation(200, 10);
		jlSeconds.setSize(40, 20);
		

		lbCancel = new JButton();
		
		
		lbAccept = new JButton();
		
		
		JPanel jpInterface = new JPanel();
		jpInterface.setLayout( new AbsoluteLayout() );
		jpInterface.setLocation(0, 0);
		jpInterface.setSize(230, 160);
		jpInterface.setPreferredSize( jpInterface.getSize() );
		jpInterface.add(jtfHours);
		jpInterface.add(jtfMins);
		jpInterface.add(jtfSecs);
		jpInterface.add(jlHours);
		jpInterface.add(jlMinutes);
		jpInterface.add(jlSeconds);
		jpInterface.add(lbCancel);
		jpInterface.add(lbAccept);
		
		setTitle(title);
		setResizable(false);
		add(jpInterface);
		pack();
		setLocationRelativeTo(null);
	}
	
	public void setCancelCommand(ActionCommand ac) {lbCancel.addActionListener(ac);}
	public void setAcceptCommand(ActionCommand ac) {lbAccept.addActionListener(ac);}

	public String getHoursInput() {return jtfHours.getText();}
	public String getMinutesInput() {return jtfMins.getText();}
	public String getSecondsInput() {return jtfSecs.getText();}
	
}
