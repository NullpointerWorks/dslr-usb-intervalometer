package com.nullpointerworks.intervalometer.util;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * A directory string builder.
 * @author Michiel Drost - Nullpointer Works
 * @version 1.1.0
 */
public class PathBuilder 
{
	private List<String> folders = null;
	private String file = "";
	
	/**
	 * 
	 * @since 1.0.0
	 */
	public PathBuilder()
	{
		folders = new ArrayList<String>();
	}
	
	/**
	 * 
	 * @since 1.0.0
	 */
	public PathBuilder(String path) 
	{
		this();
		parsePath(path);
	}

	/*
	 * copy constructor
	 * @since 1.0.0
	 */
	private PathBuilder(List<String> d, String file) 
	{
		this();
		for (String dir : d) pushFolder(dir);
		this.setFileName(file);
	}
	
	// ========================================================================
	
	/**
	 * 
	 * @since 1.0.0
	 */
	public PathBuilder pushFolder(String folder)
	{
		folder = folder.replace("\\", "/");
		String[] nav = folder.split("/");
		for (int i=0,l=nav.length; i<l; i++)
		{
			String s = nav[i];
			if (s.equalsIgnoreCase("")) continue;
			{
				folders.add(s);
			}
		}
		return this;
	}
	
	/**
	 * 
	 * @since 1.0.0
	 */
	public PathBuilder popFolder()
	{
		folders.remove(folders.size()-1);
		return this;
	}
	
	/**
	 * 
	 * @since 1.0.0
	 */
	public String getFolderPath()
	{
		String res = "";
		for (String f : folders)
		{
			res = res + f + "/";
		}
		return res;
	}
	
	/**
	 * 
	 * @since 1.0.0
	 */
	public String getAbsolutePath()
	{
		return getFolderPath() + getFileName();
	}
	
	/**
	 * 
	 * @since 1.0.0
	 */
	public String getFileName()
	{
		return file;
	}
	
	/**
	 * 
	 * @since 1.1.0
	 */
	public String getFileExtension()
	{
		int i = file.lastIndexOf(".");
		if (i >= 0) 
		{
			return file.substring(i);
		}
		return "";
	}
	
	/**
	 * 
	 * @since 1.0.0
	 */
	public PathBuilder setFileName(String file)
	{
		if (file == null) 
		{
			this.file = "";
			return this;
		}
		
		file=file.trim();
		if (file.length() < 1) 
		{
			this.file = "";
			return this;
		}
		
		this.file = file;
		return this;
	}
	
	/**
	 * 
	 * @since 1.1.0
	 */
	public PathBuilder setFileExtension(String ext)
	{
		ext = ext.trim();
		
		int i = file.lastIndexOf(".");
		if (i >= 0) 
		{
			file = file.substring(0,i) + ext;
		}
		
		return this;
	}
	
	// ========================================================================
	
	/**
	 * 
	 * @since 1.0.0
	 */
	public boolean isFolderOnly()
	{
		String file = getFileName();//+getFileExtension();
		return file.equalsIgnoreCase("");
	}
	
	/**
	 * 
	 * @since 1.0.0
	 */
	public PathBuilder getCopy()
	{
		String file = getFileName();//+getFileExtension();
		return new PathBuilder(folders,file);
	}
	
	/**
	 * 
	 * @return the name of the folder popped
	 * @since 1.0.0
	 */
	public String getAndPopFolder()
	{
		return folders.remove(folders.size()-1);
	}
	
	/**
	 * 
	 * @since 1.0.0
	 */
	public boolean exists() 
	{
		return new File(getAbsolutePath()).exists();
	}
	
	/**
	 * 
	 * @since 1.0.0
	 */
	public void create() 
	{
		new File(getFolderPath()).mkdirs();
		if (file==null) return;
		
		String file = getFileName();//+getFileExtension();
		if (file.equals("")) return;
		
		try 
		{
			new File(getAbsolutePath()).createNewFile();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * @since 1.0.0
	 */
	public PathBuilder concatinate(PathBuilder url)
	{
		pushFolder(url.getFolderPath());
		setFileName(url.getFileName());
		return this;
	}
	
	// ========================================================================
	
	/*
	 * @since 1.1.0
	 */
	private void parsePath(String path) 
	{
		boolean fend = false;
		path = path.replace("\\", "/");
		String[] tokens = path.split("/");
		
		if (tokens.length < 1) return;
		
		String finalDir = tokens[tokens.length-1];
		if (finalDir.contains("."))
		{
			fend = true;
			setFileName( tokens[tokens.length-1] );
		}
		
		int i=0;
		int l=tokens.length - ((fend)?1:0);
		for (; i<l; i++)
		{
			folders.add(tokens[i]);
		}
	}
}
