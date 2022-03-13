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
	
	//private final Font fLarge = new Font("Calibri", Font.BOLD, 28);
	
	private JTextField jtfHours;
	private JTextField jtfMins;
	private JTextField jtfSecs;
	
	private JButton jbCancel;
	private JButton jbAccept;
	
	private boolean isAccepted;
	
	public TimeTunerJDialog(String title)
	{
		super(null, Dialog.ModalityType.APPLICATION_MODAL);
		isAccepted = false;
		
		jtfHours = new JTextField();
		jtfHours.setLocation(25, 10);
		jtfHours.setSize(40, 20);
		jtfHours.setDocument( new JTextFieldFilter( JTextFieldFilter.NUMERIC ) );
		jtfHours.setHorizontalAlignment( JTextField.RIGHT );
		jtfHours.setToolTipText( "The amount of hours for the exposure." );
		jtfHours.setText("0");
		
		JLabel jlHours = new JLabel(":");
		jlHours.setLocation(75, 10);
		jlHours.setSize(30, 20);
		
		jtfMins = new JTextField();
		jtfMins.setLocation(90, 10);
		jtfMins.setSize(40, 20);
		jtfMins.setDocument( new JTextFieldFilter( JTextFieldFilter.NUMERIC ) );
		jtfMins.setHorizontalAlignment( JTextField.RIGHT );
		jtfMins.setToolTipText( "The amount of minutes for the exposure." );
		jtfMins.setText("0");
		
		JLabel jlMinutes = new JLabel(":");
		jlMinutes.setLocation(140, 10);
		jlMinutes.setSize(40, 20);
		
		jtfSecs = new JTextField();
		jtfSecs.setLocation(155, 10);
		jtfSecs.setSize(40, 20);
		jtfSecs.setDocument( new JTextFieldFilter( JTextFieldFilter.NUMERIC ) );
		jtfSecs.setHorizontalAlignment( JTextField.RIGHT );
		jtfSecs.setToolTipText( "The amount of seconds for the exposure." );
		jtfSecs.setText("30");
		
		jbAccept = new JButton("Accept");
		jbAccept.setLocation(10, 85);
		jbAccept.setSize(90, 25);
		jbAccept.setPreferredSize(jbAccept.getSize());
		setAcceptCommand(new ActionCommand() 
		{
			@Override
			public void onCommand() 
			{
				isAccepted = true;
				setVisible(false);
			}
		});
		
		jbCancel = new JButton("Cancel");
		jbCancel.setLocation(127, 85);
		jbCancel.setSize(90, 25);
		jbCancel.setPreferredSize(jbCancel.getSize());
		setCancelCommand(new ActionCommand() 
		{
			@Override
			public void onCommand() 
			{
				isAccepted = false;
				setVisible(false);
			}
		});
		
		JPanel jpInterface = new JPanel();
		jpInterface.setLayout( new AbsoluteLayout() );
		jpInterface.setLocation(0, 0);
		jpInterface.setSize(230, 120);
		jpInterface.setPreferredSize( jpInterface.getSize() );
		jpInterface.add(jtfHours);
		jpInterface.add(jtfMins);
		jpInterface.add(jtfSecs);
		jpInterface.add(jlHours);
		jpInterface.add(jlMinutes);
		jpInterface.add(jbCancel);
		jpInterface.add(jbAccept);
		
		setTitle(title);
		setResizable(false);
		add(jpInterface);
		pack();
		setLocationRelativeTo(null);
	}
	
	public boolean isAccepted() {return isAccepted;}
	
	private void setAcceptCommand(ActionCommand ac) {jbAccept.addActionListener(ac);}
	private void setCancelCommand(ActionCommand ac) {jbCancel.addActionListener(ac);}
	
	public String getHoursInput() {return jtfHours.getText();}
	public String getMinutesInput() {return jtfMins.getText();}
	public String getSecondsInput() {return jtfSecs.getText();}
	
	public void setStartDelayText(long hours, long mins, long secs) 
	{
		jtfHours.setText(""+hours);
		jtfMins.setText(""+mins);
		jtfSecs.setText(""+secs);
	}
	
}
