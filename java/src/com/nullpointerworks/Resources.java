package com.nullpointerworks;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class Resources 
{
	private static final String PENCIL = "/com/nullpointerworks/resources/pencil.png";
	
	private static final Icons icon = new Icons();
	public static Icons getIcons() {return icon;}
	public static class Icons
	{
		private final Map<String, Icon> flyweight = new HashMap<String, Icon>();
		private Icon getIcon(String path) 
		{
			if (flyweight.containsKey(path))
			{
				return flyweight.get(path);
			}
			Icon ico = new ImageIcon( Loader.getResource(path) );
			flyweight.put(path, ico);
			return ico;
		}
		
		public Icon getEditPencil() {return getIcon(PENCIL);}
	}
	
	private static final Images images = new Images();
	public static Images getImages() {return images;}
	public static class Images
	{
		private final Map<String, BufferedImage> flyweight = new HashMap<String, BufferedImage>();
		
		private BufferedImage getImage(String path) 
		{
			if (flyweight.containsKey(path))
			{
				return flyweight.get(path);
			}
			BufferedImage ico = getStreamedImage(path);
			flyweight.put(path, ico);
			return ico;
		}
		
		private BufferedImage getStreamedImage(String path) 
		{
			InputStream is = Loader.getResourceAsStream(path);
	        BufferedImage img = null;
			try 
			{
				img = ImageIO.read(is);
			} 
			catch (IOException e)
			{
				e.printStackTrace();
			}
			if (img==null) return null;
			
			return img;
		}
		
		public BufferedImage getEditPencil() {return getImage(PENCIL);}
	}
}
