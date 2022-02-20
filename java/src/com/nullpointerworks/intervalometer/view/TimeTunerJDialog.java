package com.nullpointerworks.intervalometer.view;

import java.awt.Dialog;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.nullpointerworks.intervalometer.view.awt.AbsoluteLayout;

public class TimeTunerJDialog extends JDialog 
{
	private static final long serialVersionUID = 913577687449225667L;
	
	private JTextField jtfHours;
	
	
	public TimeTunerJDialog(String title)
	{
		super(null, Dialog.ModalityType.APPLICATION_MODAL);
		
		
		
		
		
		jtfHours = new JTextField();
		jtfHours.setLocation(10, 10);
		jtfHours.setSize(80, 20);
		
		
		JLabel jlHours = new JLabel("H");
		jlHours.setLocation(95, 10);
		jlHours.setSize(30, 20);
		
		
		
		
		
		
		JLabel jlMinutes = new JLabel("'");
		
		
		
		
		JLabel jlSeconds = new JLabel("\"");
		
		
		
		
		
		
		
		
		JPanel jpInterface = new JPanel();
		jpInterface.setLayout( new AbsoluteLayout() );
		jpInterface.setLocation(0, 0);
		jpInterface.setSize(320, 240);
		jpInterface.setPreferredSize( jpInterface.getSize() );
		jpInterface.add(jtfHours);
		jpInterface.add(jlHours);
		
		setTitle(title);
		setResizable(false);
		add(jpInterface);
		pack();
		setLocationRelativeTo(null);
	}
	
	
	
	
	
	
}
