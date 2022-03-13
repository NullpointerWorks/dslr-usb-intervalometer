package com.nullpointerworks.intervalometer.view.swing;

import java.awt.Component;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Icon;
import javax.swing.JTabbedPane;

import com.nullpointerworks.intervalometer.control.interfaces.ActionCommand;

public class CustomHeaderJTabbedPane extends JTabbedPane
{
	private static final long serialVersionUID = -8498443122815430449L;
	
	private List<Component> tracking;
	
	public CustomHeaderJTabbedPane()
	{
		super();
		tracking = new ArrayList<Component>();
	}
	
	private ActionTabHeader createActionPanel(CustomHeaderJTabbedPane parent, Icon icon, final Component comp, String title) 
	{
		return new ActionTabHeader(parent, title, comp, icon);
	}
	
	public ActionTabHeader addActionTab(String title, Icon icon, Component comp, ActionCommand ac)
	{
		add(comp);
		int index = indexOfComponent(comp);
		if (index < 0) return null;
		
		ActionTabHeader panel = createActionPanel(this, icon, comp, title );
		panel.setTabButtonCommand(ac);
		setTabComponentAt( index, panel );
		return panel;
	}
	
	public Component addPermanentTab(String title, Component comp)
	{
		if (tracking.contains(comp)) return comp;
		tracking.add(comp);
		super.add(title, comp);
		return comp;
	}
	
	@Override
	public void addTab(String title, Icon icon, Component comp)
	{
		addActionTab(title, icon, comp, null);
	}
	
	@Override
	public Component add(Component comp)
	{
		return add(comp.getName(), comp);
	}
	
	@Override
	public Component add(String title, Component comp)
	{
		addPermanentTab(title, comp);
		
		int index = indexOfComponent(comp);
		if (index < 0) return comp;
		ActionTabHeader panel = createActionPanel(this, null, comp, title );
		setTabComponentAt( index, panel );
		
		return comp;
	}
	
	public void removeComponent(final Component comp)
	{
		remove(comp);
		tracking.remove(comp);
	}
}
