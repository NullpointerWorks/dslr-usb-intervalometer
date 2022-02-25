package com.nullpointerworks.intervalometer.view.swing;

import java.awt.Component;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Icon;
import javax.swing.JTabbedPane;

public class CustomHeaderJTabbedPane extends JTabbedPane
{
	private static final long serialVersionUID = -8498443122815430449L;
	
	private List<Component> tracking;
	
	public CustomHeaderJTabbedPane()
	{
		super();
		tracking = new ArrayList<Component>();
	}
	
	public ActionTabHeader addActionTab(String title, Icon icon, Component comp)
	{
		add(comp);
		int index = indexOfComponent(comp);
		if (index < 0) return null;
		
		ActionTabHeader panel = createActionPanel(this, icon, comp, title );
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
		addActionTab(title, icon, comp);
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
	
	private ActionTabHeader createActionPanel(CustomHeaderJTabbedPane parent, Icon icon, final Component comp, String title) 
	{
		return new ActionTabHeader(parent, title, comp, icon);
	}
	
	public void removeComponent(final Component comp)
	{
		remove(comp);
		tracking.remove(comp);
	}
}
