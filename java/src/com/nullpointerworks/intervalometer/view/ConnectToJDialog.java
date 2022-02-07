package com.nullpointerworks.intervalometer.view;

import javax.swing.JPanel;
import javax.swing.JTextField;

import com.nullpointerworks.intervalometer.view.awt.AbsoluteLayout;

import java.awt.Dialog;

import javax.swing.JDialog;

public class ConnectToJDialog extends JDialog
{
	private static final long serialVersionUID = -1264853779154090521L;
	
	private boolean isAccepted;
	private JTextField jtfSerialInput;
	
	public ConnectToJDialog()
	{
		super(null, Dialog.ModalityType.APPLICATION_MODAL);
		
		isAccepted = false;
		
		
		jtfSerialInput = new JTextField();
		jtfSerialInput.setLocation(20, 20);
		jtfSerialInput.setSize(150, 25);
		jtfSerialInput.setPreferredSize(jtfSerialInput.getSize());
		
		
		
		JPanel jpInterface = new JPanel();
		jpInterface.setLayout( new AbsoluteLayout() );
		jpInterface.setLocation(0, 0);
		jpInterface.setSize(320, 240);
		jpInterface.setPreferredSize( jpInterface.getSize() );
		jpInterface.add(jtfSerialInput);
		
		setTitle("Connect To Device");
		setResizable(false);
		add(jpInterface);
		pack();
		setLocationRelativeTo(null);
	}
	
	public String getSerialNumber()
	{
		return jtfSerialInput.getText().trim();
	}
	
	public boolean isAccepted()
	{
		return isAccepted;
	}
}
