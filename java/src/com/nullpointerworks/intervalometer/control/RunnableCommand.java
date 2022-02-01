package com.nullpointerworks.intervalometer.control;

public interface RunnableCommand extends Command, Runnable 
{
	@Override
	public default void run()
	{
		onCommand();
	}
}
