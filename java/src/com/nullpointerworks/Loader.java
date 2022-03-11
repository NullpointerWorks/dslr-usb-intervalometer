package com.nullpointerworks;

import java.io.InputStream;
import java.net.URL;

final class Loader 
{
	public static URL getResource(String path)
	{
		return instance.getClass().getResource(path);
	}
	
	public static InputStream getResourceAsStream(String path)
	{
		return instance.getClass().getResourceAsStream(path);
	}
	
	private Loader() {}
	private static Loader instance = new Loader();
}
