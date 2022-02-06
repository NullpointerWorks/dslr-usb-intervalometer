package com.nullpointerworks.intervalometer.view.swing;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.geom.Line2D;

import javax.swing.border.AbstractBorder;

public class ChippedLineBorder extends AbstractBorder
{
	private static final long serialVersionUID = -3688570447222580954L;
	
	private Color borderColor;
	private Insets inset;
	
    public ChippedLineBorder(Color c)
    {
        borderColor = c;
        inset = new Insets(0,0,0,0);
    }
	
    public ChippedLineBorder(Color c, int top, int left, int bottom, int right)
    {
        borderColor = c;
        inset = new Insets(top, left, bottom, right);
    }
    
    @Override
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height)
    {
        super.paintBorder(c, g, x, y, width, height);
        Graphics2D g2d = null;
        if (g instanceof Graphics2D)
        {
            g2d = (Graphics2D) g;
            draw(g2d,borderColor,x,y,width,height);
        }
    }
    
    private void draw(Graphics2D g2d, Color c, double x, double y, double w, double h) 
    {
        w-=1;
        h-=1;
        g2d.setColor(c);
        g2d.draw( new Line2D.Double( x+1,   y,     x+w-1, y) );
        g2d.draw( new Line2D.Double( x+w,   y+1,   x+w,   y+h-1) );
        g2d.draw( new Line2D.Double( x+w-1, y+h,   x+1,   y+h) );
        g2d.draw( new Line2D.Double( x,     y+h-1, x,     y+1) );
	}
	
    @Override
    public Insets getBorderInsets(Component c, Insets insets)
    {
    	insets.top 		= inset.top;
    	insets.left 	= inset.left;
    	insets.bottom 	= inset.bottom;
    	insets.right 	= inset.right;
        return insets;
    }
    
	@Override
    public Insets getBorderInsets(Component c)
    {
        return getBorderInsets(c, new Insets(inset.top, inset.left, inset.bottom, inset.right));
    }
    
    @Override
    public boolean isBorderOpaque()
    {
        return true;
    }
}
