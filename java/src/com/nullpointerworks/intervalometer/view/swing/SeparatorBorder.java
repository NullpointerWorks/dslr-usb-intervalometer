package com.nullpointerworks.intervalometer.view.swing;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.geom.Line2D;

import javax.swing.border.AbstractBorder;

public class SeparatorBorder extends AbstractBorder
{
	private static final long serialVersionUID = -3688570447222580954L;
	
	private Color borderColor;
	
    public SeparatorBorder(Color c)
    {
        borderColor = c;
    }
    
    @Override
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height)
    {
        super.paintBorder(c, g, x, y, width, height);
        Graphics2D g2d = null;
        if (g instanceof Graphics2D)
        {
            g2d = (Graphics2D) g;
            draw(g2d,borderColor,x,y+2,width,height-4);
        }
    }
    
    private void draw(Graphics2D g2d, Color c, double x, double y, double w, double h) 
    {
        w-=1;
        h-=1;
        g2d.setColor(c);
        g2d.draw( new Line2D.Double( (double)x + w, (double)y, (double)x + w, (double)y + h) );
	}
    
	@Override
    public Insets getBorderInsets(Component c)
    {
        return getBorderInsets(c, new Insets(0, 0, 0, 0));
    }
	
    @Override
    public Insets getBorderInsets(Component c, Insets insets)
    {
    	insets.top 		= 0;
    	insets.bottom 	= 0;
    	insets.left 	= 4;
    	insets.right 	= 4;
        return insets;
    }
    
    @Override
    public boolean isBorderOpaque()
    {
        return true;
    }
}
