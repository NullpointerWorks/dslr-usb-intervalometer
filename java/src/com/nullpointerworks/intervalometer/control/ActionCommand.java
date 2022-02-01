package com.nullpointerworks.intervalometer.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public interface ActionCommand extends RunnableCommand, ActionListener 
{
	// Swing related bugfix:
	// - Create new thread instead which calls the onCommand() method.
	// - Swing UI threads hang until other UI methods complete due to concurrency issues
	@Override
	public default void actionPerformed(ActionEvent e)
	{
		Thread t = new Thread(this);
		t.start();
	}
}
