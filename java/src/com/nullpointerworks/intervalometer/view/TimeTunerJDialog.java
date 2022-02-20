package com.nullpointerworks.intervalometer.view;

import java.awt.Dialog;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.nullpointerworks.intervalometer.view.awt.AbsoluteLayout;

public class TimeTunerJDialog extends JDialog 
{
	private static final long serialVersionUID = 913577687449225667L;

	public TimeTunerJDialog(String title)
	{
		super(null, Dialog.ModalityType.APPLICATION_MODAL);
		
		
		
		

		JLabel jlHours = new JLabel("h");
		
		
		JLabel jlMinutes = new JLabel("'");
		
		JLabel jlSeconds = new JLabel("\"");
		
		
		
		
		
		
		
		
		JPanel jpInterface = new JPanel();
		jpInterface.setLayout( new AbsoluteLayout() );
		jpInterface.setLocation(0, 0);
		jpInterface.setSize(320, 240);
		jpInterface.setPreferredSize( jpInterface.getSize() );
		
		setTitle(title);
		setResizable(false);
		add(jpInterface);
		pack();
		setLocationRelativeTo(null);
	}
	
	
	
	
	
	
}
