package com.nullpointerworks.intervalometer.model.config;

import exp.nullpointerworks.xml.Element;

public interface ConfigItem 
{
	String name();
	Element make();
	void verify(Element root);
}
