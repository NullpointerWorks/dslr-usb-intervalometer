package com.nullpointerworks.intervalometer.model;

import com.nullpointerworks.intervalometer.util.PathBuilder;
import com.nullpointerworks.intervalometer.util.XMLLoader;

import exp.nullpointerworks.xml.Document;
import exp.nullpointerworks.xml.Element;

public class XMLProfileIO implements ProfileIO
{
	private XMLLoader loader;
	
	public XMLProfileIO()
	{
		loader = new XMLLoader();
	}
	
	public boolean write(IntervalProfile profile, PathBuilder path)
	{
		Element root = new Element("Profile");
		Document doc = new Document(root);
		
		Element name = new Element("Name");
		Element notes = new Element("Notes");
		Element start = new Element("StartDelay");
		Element extime = new Element("ExposureTime");
		Element tween = new Element("InBetweenDelay");
		Element expo = new Element("Exposures");
		
		
		name.setText( profile.getProfileName() );
		notes.setText( profile.getProfileNotes() );
		
		
		
		
		
		
		root.addChild(name);
		root.addChild(notes);
		root.addChild(start);
		root.addChild(extime);
		root.addChild(tween);
		root.addChild(expo);
		
		return loader.saveXML(doc, path);
	}

	@Override
	public boolean read(IntervalProfile profile, PathBuilder path) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	
	
	
}
