package com.nullpointerworks.intervalometer.view;

import java.awt.Dialog;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.nullpointerworks.intervalometer.control.interfaces.ActionCommand;
import com.nullpointerworks.intervalometer.view.awt.AbsoluteLayout;

public class ChangeNameJDialog extends JDialog 
{
	private static final long serialVersionUID = 913577687449225667L;
	
	//private final Font fLarge = new Font("Calibri", Font.BOLD, 28);
	
	private JTextField jtfName;
	private JButton jbCancel;
	private JButton jbAccept;
	private boolean isAccepted;
	
	public ChangeNameJDialog()
	{
		super(null, Dialog.ModalityType.APPLICATION_MODAL);
		isAccepted = false;
		
		jtfName = new JTextField();
		jtfName.setLocation(25, 30);
		jtfName.setSize(170, 20);
		jtfName.setHorizontalAlignment( JTextField.CENTER );
		jtfName.setText("NewProfile");
		
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
		jpInterface.add(jtfName);
		jpInterface.add(jbCancel);
		jpInterface.add(jbAccept);
		
		setTitle("Change Name");
		setResizable(false);
		add(jpInterface);
		pack();
		setLocationRelativeTo(null);
	}
	
	public boolean isAccepted() {return isAccepted;}
	
	private void setAcceptCommand(ActionCommand ac) {jbAccept.addActionListener(ac);}
	private void setCancelCommand(ActionCommand ac) {jbCancel.addActionListener(ac);}
	
	public String getNameText() {return jtfName.getText();}
	public void setNameText(String name) {jtfName.setText(name);}
	
}
