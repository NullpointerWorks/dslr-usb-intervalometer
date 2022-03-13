package com.nullpointerworks.intervalometer.model.profile;

import com.nullpointerworks.intervalometer.util.PathBuilder;
import com.nullpointerworks.intervalometer.util.XMLLoader;
import com.nullpointerworks.util.Convert;

import exp.nullpointerworks.xml.Document;
import exp.nullpointerworks.xml.Element;

public class XMLProfileIO implements ProfileIO
{
	private XMLLoader loader;
	
	public XMLProfileIO()
	{
		loader = new XMLLoader();
	}
	
	@Override
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

		start.setText( ""+profile.getStartDelay() );
		extime.setText( ""+profile.getExposureTime() );
		tween.setText( ""+profile.getBetweenDelay() );
		expo.setText( ""+profile.getExposures() );
		
		
		
		root.addChild(name);
		root.addChild(notes);
		root.addChild(start);
		root.addChild(extime);
		root.addChild(tween);
		root.addChild(expo);
		
		return loader.saveXML(doc, path);
	}
	
	@Override
	public boolean read(IntervalProfile profile, PathBuilder path) 
	{
		Document doc = loader.loadXML(path);
		if (doc == null) return false;
		Element root = doc.getRootElement();

		// set name
		Element name = root.getChild("Name");
		if (name != null)
		{
			profile.setProfileName( name.getText() );
		}
		
		// set notes
		Element note = root.getChild("Notes");
		if (note != null)
		{
			profile.setProfileNotes( note.getText() );
		}
		else
		{
			profile.setProfileNotes("");
		}
		
		// set startup delay
		Element sdelay = root.getChild("StartDelay");
		if (sdelay != null)
		if (hasText(sdelay))
		{
			String s = sdelay.getText();
			int i = Convert.toInt(s);
			profile.setStartDelay(i);
		}
		
		// set startup delay
		Element expTime = root.getChild("ExposureTime");
		if (expTime != null)
		if (hasText(expTime))
		{
			String s = expTime.getText();
			int i = Convert.toInt(s);
			profile.setExposureTime(i);
		}
		
		// set startup delay
		Element tween = root.getChild("InBetweenDelay");
		if (tween != null)
		if (hasText(tween))
		{
			String s = tween.getText();
			int i = Convert.toInt(s);
			profile.setBetweenDelay(i);
		}
		
		// set startup delay
		Element expo = root.getChild("Exposures");
		if (expo != null)
		if (hasText(expo))
		{
			String s = expo.getText();
			int i = Convert.toInt(s);
			profile.setExposures(i);
		}
		
		return true;
	}
	
	private boolean hasText(Element e)
	{
		String s = e.getText();
		if (s==null) return false;
		if (s.length()<1) return false;
		return true;
	}
}
