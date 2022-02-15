package com.nullpointerworks.intervalometer.model;

import com.nullpointerworks.intervalometer.model.profile.IntervalProfile;
import com.nullpointerworks.intervalometer.util.PathBuilder;
import com.nullpointerworks.intervalometer.util.XMLLoader;

import exp.nullpointerworks.xml.Document;
import exp.nullpointerworks.xml.Element;

public class ProfileBuilder 
{
	private XMLLoader loader;
	
	public ProfileBuilder()
	{
		loader = new XMLLoader();
	}
	
	public boolean write(IntervalProfile profile, PathBuilder path)
	{
		Element root = new Element("Profile");
		Document doc = new Document(root);
		
		
		
		return loader.saveXML(doc, null);
	}
	
	
	
	
	
}
