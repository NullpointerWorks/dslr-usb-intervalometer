package com.nullpointerworks.intervalometer.model.config;

import java.util.ArrayList;
import java.util.List;

import com.nullpointerworks.intervalometer.model.config.item.BoolConfigItem;
import com.nullpointerworks.intervalometer.model.config.item.StringConfigItem;
import com.nullpointerworks.intervalometer.util.PathBuilder;
import com.nullpointerworks.intervalometer.util.XMLLoader;

import exp.nullpointerworks.xml.Document;
import exp.nullpointerworks.xml.Element;
import exp.nullpointerworks.xml.Encoding;
import exp.nullpointerworks.xml.Version;
import exp.nullpointerworks.xml.prolog.XMLProlog;

public class XMLConfiguration implements Configuration 
{
	private List<ConfigItem> items;
	private final PathBuilder cnfgPath;
	private XMLLoader loader;
	private Document doc = null;
	private Element root = null;
	
	public XMLConfiguration(PathBuilder appURL)
	{
		loader = new XMLLoader();
		
		cnfgPath = appURL.getCopy();
		cnfgPath.setFileName("config.xml");
		
		items = new ArrayList<ConfigItem>();
		items.add( new BoolConfigItem("AudioAlarm", false) );
		items.add( new BoolConfigItem("VisualAlarm", false) );
		items.add( new StringConfigItem("Recent.Devices.Device", "") );
		
		if (!loader.existsXML(cnfgPath))
		{
			doc = makeDefault(cnfgPath);
		}
		else
		{
			doc = verifyFile(cnfgPath);
		}
		root = doc.getRootElement();
	}
	
	// ===================================================================
	
	public boolean getAudioAlarm()
	{
		Element el = root.getChild("AudioAlarm");
		return el.getText().equalsIgnoreCase("true");
	}
	
	public boolean getVisualAlarm()
	{
		Element el = root.getChild("VisualAlarm");
		return el.getText().equalsIgnoreCase("true");
	}
	
	
	
	
	
	
	// ===================================================================
	
	private Document makeDefault(PathBuilder cnf)
	{
		Element root = makeDefaultRoot(cnf.getFolderPath());
		Document doc = new Document();
		doc.setProlog( new XMLProlog(Version.V10, Encoding.UTF8) );
		doc.setRootElement(root);
		loader.saveXML(doc,cnf);
		return doc;
	}
	
	private Document verifyFile(PathBuilder cnf)
	{
		doc = loader.loadXML(cnf);
		root = doc.getRootElement();
		
		if (root == null)
		{
			Element root = makeDefaultRoot(cnf.getFolderPath());
			doc.setProlog( new XMLProlog(Version.V10, Encoding.UTF8) );
			doc.setRootElement(root);
		}
		else
		{
			for (ConfigItem item : items)
			{
				item.verify(root);
			}
		}
		
		loader.saveXML(doc,cnf);
		return doc;
	}
	
	private Element makeDefaultRoot(String path)
	{
		Element root = new Element("Configuration");
		for (ConfigItem item : items)
		{
			root.addChild( item.make() );
		}
		return root;
	}
}
