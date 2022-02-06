package com.nullpointerworks.intervalometer.control.interfaces;

public interface RunnableCommand extends Command, Runnable 
{
	@Override
	public default void run()
	{
		onCommand();
	}
}
