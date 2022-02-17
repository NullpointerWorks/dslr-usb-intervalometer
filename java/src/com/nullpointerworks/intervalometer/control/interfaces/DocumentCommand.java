package com.nullpointerworks.intervalometer.control.interfaces;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public interface DocumentCommand extends Command, DocumentListener
{
	public default void insertUpdate(DocumentEvent e)
	{
		onCommand();
	}
	
    public default void removeUpdate(DocumentEvent e)
	{
    	onCommand();
	}
	
    public default void changedUpdate(DocumentEvent e)
	{
    	onCommand();
	}
}
