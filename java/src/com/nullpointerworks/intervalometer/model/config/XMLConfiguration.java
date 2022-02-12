package com.nullpointerworks.intervalometer.model.config;

import java.util.ArrayList;
import java.util.List;

import com.nullpointerworks.intervalometer.model.config.item.BoolConfigItem;
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
	
	public List<String> getRecentDevices()
	{
		List<String> list = new ArrayList<String>();
		List<Element> children = root.getChildren("RecentDevice");
		for (Element child : children)
		{
			list.add(child.getText());
		}
		return list;
	}
	
	public List<String> getRecentProfiles()
	{
		List<String> list = new ArrayList<String>();
		List<Element> children = root.getChildren("RecentProfile");
		for (Element child : children)
		{
			list.add(child.getText());
		}
		return list;
	}
	
	public void setRecentDevice(String sn)
	{
		List<String> check = getRecentDevices();
		for (String serial : check)
		{
			if (serial.equalsIgnoreCase(sn)) return;
		}
		
		var el = new Element("RecentDevice");
		el.setText(sn);
		root.addChild(el);
		loader.saveXML(doc, cnfgPath);
	}
	
	public void setRecentProfile(String pro)
	{
		List<String> check = getRecentProfiles();
		for (String profile : check)
		{
			if (profile.equalsIgnoreCase(pro)) return;
		}
		
		var el = new Element("RecentProfile");
		el.setText(pro);
		root.addChild(el);
		loader.saveXML(doc, cnfgPath);
	}
	
	public void clearRecentDevices()
	{
		List<Element> children = root.getChildren("RecentDevice");
		int l = children.size() - 1;
		for (; l>=0; l--)
		{
			Element child = children.get(l);
			root.remChild(child);
		}
		loader.saveXML(doc, cnfgPath);
	}
	
	public void clearRecentProfiles()
	{
		List<Element> children = root.getChildren("RecentProfile");
		int l = children.size() - 1;
		for (; l>=0; l--)
		{
			Element child = children.get(l);
			root.remChild(child);
		}
		loader.saveXML(doc, cnfgPath);
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
