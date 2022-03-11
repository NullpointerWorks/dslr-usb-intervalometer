package com.nullpointerworks.intervalometer.view.swing;

import java.awt.Component;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.nullpointerworks.intervalometer.control.interfaces.ActionCommand;

public class ActionTabHeader extends JPanel
{
	private static final long serialVersionUID = -73302653717502663L;
	
	private JButton closeButton;
	private JLabel pretitle;
	private JLabel title;
	
	public ActionTabHeader(CustomHeaderJTabbedPane parent, String name, final Component comp, Icon icon)
	{
		pretitle = new JLabel("");
		title = new JLabel(" "+name+" ");
		title.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 4));
		
		setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
		setOpaque(false);
		
		closeButton = new JButton(icon);
		closeButton.setSize(18, 18);
		closeButton.setPreferredSize(closeButton.getSize());
		closeButton.setOpaque(false);
		closeButton.setContentAreaFilled(false);
		//closeButton.setBorderPainted(false);
		//closeButton.setFocusPainted(false);
		
		//if (icon!=null) add(new JLabel(icon));
		add(pretitle);
		add(title);
		add(closeButton);
	}
	
	public void setTabButtonCommand(ActionCommand c) {closeButton.addActionListener(c);}
	
	public void setPreTitle(String txt)
	{
		pretitle.setText(txt);
		this.repaint();
	}
	
	public void setTitle(String txt)
	{
		title.setText(txt);
		this.repaint();
	}
	
	public String getTitle()
	{
		return title.getText();
	}
}
