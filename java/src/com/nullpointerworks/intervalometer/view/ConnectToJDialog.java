package com.nullpointerworks.intervalometer.view;

import javax.swing.JPanel;
import javax.swing.JTextField;

import com.nullpointerworks.intervalometer.view.awt.AbsoluteLayout;
import com.nullpointerworks.intervalometer.view.swing.JTextFieldFilter;

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
		jlEnterSerial.setLocation(15, 15);
		jlEnterSerial.setSize(100, 25);
		jlEnterSerial.setPreferredSize(jlEnterSerial.getSize());
		
		jtfSerialInput = new JTextField();
		jtfSerialInput.setLocation(100, 15);
		jtfSerialInput.setSize(170, 25);
		jtfSerialInput.setPreferredSize(jtfSerialInput.getSize());
		//jtfSerialInput.setDocument( new JTextFieldFilter(JTextFieldFilter.NUMERIC) );
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
		jbAccept.setLocation(10, 55);
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
		jbCancel.setLocation(175, 55);
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
		jpInterface.setSize(280, 95);
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
