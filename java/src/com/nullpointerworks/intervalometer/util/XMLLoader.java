package com.nullpointerworks.intervalometer.util;

import java.io.File;
import java.io.IOException;

import exp.nullpointerworks.xml.Document;
import exp.nullpointerworks.xml.Element;
import exp.nullpointerworks.xml.Encoding;
import exp.nullpointerworks.xml.FormatFactory;
import exp.nullpointerworks.xml.Version;
import exp.nullpointerworks.xml.XMLParseException;
import exp.nullpointerworks.xml.prolog.Prolog;
import exp.nullpointerworks.xml.prolog.XMLProlog;
import exp.nullpointerworks.xml.format.Format;
import exp.nullpointerworks.xml.io.DOMDocumentLoader;
import exp.nullpointerworks.xml.io.DOMLoader;
import exp.nullpointerworks.xml.io.DocumentWriter;

public class XMLLoader 
{
	private final Format format = FormatFactory.getPrettyWindowsFormat();
	private final Prolog prolog = new XMLProlog(Version.V10, Encoding.UTF8);
	private final DocumentWriter writer = new DocumentWriter(format);
	
	public final Document loadXML(PathBuilder path)
	{
		DOMLoader dl = new DOMDocumentLoader();
		Document doc = null;
		
		try
		{
			doc = dl.parse( path.getAbsolutePath() );
		} 
		catch (XMLParseException | IOException e)
		{
			e.printStackTrace();
			return null;
		}
		return doc;
	}
	
	public final boolean existsXML(PathBuilder path)
	{
		File f = new File(path.getAbsolutePath());
		return f.exists();
	}
	
	public final Document createXML(PathBuilder path, String root) 
	{
		File f = new File(path.getFolderPath());
		if (!f.exists()) f.mkdirs();
		
		Document doc = new Document();
		doc.setRootElement( new Element(root) );
		saveXML(doc, path);
		
		return doc;
	}
	
	public final boolean saveXML(Document doc, PathBuilder path)
	{
		doc.setProlog(prolog);
		try
		{
			writer.write(doc, path.getAbsolutePath() );
		} 
		catch (IOException e)
		{
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
