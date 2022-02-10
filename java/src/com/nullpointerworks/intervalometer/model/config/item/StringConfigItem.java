package com.nullpointerworks.intervalometer.model.config.item;

import com.nullpointerworks.intervalometer.model.config.ConfigItem;

import exp.nullpointerworks.xml.Element;

public class StringConfigItem implements ConfigItem
{
	private final String DEFAULT;
	private final String itemName;
	
	public StringConfigItem(String name, String def)
	{
		itemName = name;
		DEFAULT = def;
	}
	
	public String name()
	{
		return itemName;
	}
	
	@Override
	public Element make() 
	{
		var el = new Element(itemName);
		el.setText(DEFAULT);
		return el;
	}
	
	@Override
	public void verify(Element root) 
	{
		Element base = root.getChild(itemName);
		if (base == null) 
		{
			root.addChild( make() );
		}
		else 
		{
			String text = base.getText();
			if (text==null) text = "";
			if (text.length() < 1) base.setText(DEFAULT);
		}
	}
}
