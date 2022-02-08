package com.nullpointerworks.intervalometer.view;

import javax.swing.JPanel;
import javax.swing.JTextField;

import com.nullpointerworks.intervalometer.view.awt.AbsoluteLayout;
import com.nullpointerworks.intervalometer.view.swing.GhostText;

import java.awt.Dialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;

public class ConnectToJDialog extends JDialog
{
	private static final long serialVersionUID = -1264853779154090521L;
	
	private boolean isAccepted;
	private JTextField jtfSerialInput;
	private JButton jbAccept;
	private JButton jbCancel;
	
	public ConnectToJDialog()
	{
		super(null, Dialog.ModalityType.APPLICATION_MODAL);
		
		isAccepted = false;
		
		JLabel jlEnterSerial = new JLabel("Serial Number:");
		jlEnterSerial.setLocation(20, 20);
		jlEnterSerial.setSize(100, 25);
		jlEnterSerial.setPreferredSize(jlEnterSerial.getSize());
		
		jtfSerialInput = new JTextField();
		jtfSerialInput.setLocation(105, 20);
		jtfSerialInput.setSize(170, 25);
		jtfSerialInput.setPreferredSize(jtfSerialInput.getSize());
		new GhostText(jtfSerialInput, "Leave empty if unknown");
		jtfSerialInput.addKeyListener( new KeyAdapter() 
		{
			@Override
			public void keyReleased(KeyEvent e) 
			{
				int code = e.getKeyCode();
				if (code == KeyEvent.VK_ENTER)
				{
					jbAccept.doClick();
				}
			}
		});
		
		jbAccept = new JButton("Accept");
		jbAccept.setLocation(20, 70);
		jbAccept.setSize(90, 25);
		jbAccept.setPreferredSize(jbAccept.getSize());
		jbAccept.addActionListener( new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				isAccepted = true;
				setVisible(false);
			}
		});
		
		jbCancel = new JButton("Cancel");
		jbCancel.setLocation(185, 70);
		jbCancel.setSize(90, 25);
		jbCancel.setPreferredSize(jbCancel.getSize());
		jbCancel.addActionListener( new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				setVisible(false);
			}
		});
		
		JPanel jpInterface = new JPanel();
		jpInterface.setLayout( new AbsoluteLayout() );
		jpInterface.setLocation(0, 0);
		jpInterface.setSize(300, 115);
		jpInterface.setPreferredSize( jpInterface.getSize() );
		jpInterface.add(jlEnterSerial);
		jpInterface.add(jtfSerialInput);
		jpInterface.add(jbAccept);
		jpInterface.add(jbCancel);
		
		setTitle("Connect To Device");
		setResizable(false);
		add(jpInterface);
		pack();
		setLocationRelativeTo(null);
		
		jbCancel.grabFocus();
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
